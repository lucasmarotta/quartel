package br.ufba.dcc.quartel.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.forms.MilitarForm;
import br.ufba.dcc.quartel.forms.ReservaForm;
import br.ufba.dcc.quartel.forms.UsuarioForm;
import br.ufba.dcc.quartel.models.Militar;
import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.MilitarPostoService;
import br.ufba.dcc.quartel.services.MilitarService;
import br.ufba.dcc.quartel.services.ReservaService;
import br.ufba.dcc.quartel.services.UsuarioService;

@Controller
public class MilitarController extends BaseController
{
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MilitarService militarService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private MilitarPostoService militarPostoService;
	
	@GetMapping("/militar")
	public ModelAndView listarUsuario()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("militares", militarService.findAll());
		mv.setViewName("militar/listar_militar");
		return mv;
	}
	
	@GetMapping("/militar/cadastrar")
	public ModelAndView cadastrarMilitar()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("militarForm", new MilitarForm());
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(usuarioService.findUsuarioNotMilitar()));
		mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
		mv.setViewName("militar/cadastrar_militar");
		return mv;		
	}
	
	@PostMapping("/militar/cadastrar")
	public ModelAndView cadastrarMilitarForm(@Valid MilitarForm militarForm, BindingResult bindingResult)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("militarForm", militarForm);
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(usuarioService.findUsuarioNotMilitar()));
		mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("militar/cadastrar_militar");
		} else {
			
			if(militarForm.getUsuario() != null && militarForm.getUsuario() > 0) {			
				Usuario usuario = usuarioService.findById(militarForm.getUsuario());
				if(usuario == null) {
					bindingResult.rejectValue("usuario", "error.usuario", "Login não existe");
				} else if(militarService.militarUsuarioExists(usuario)) {
					bindingResult.rejectValue("usuario", "error.usuario", "Já existe um militar associado a esse login");
				}
			}
			
			if(!militarPostoService.postoExists(militarForm.getPosto())) {
				bindingResult.rejectValue("posto", "error.posto", "posto não encontrado");
			}
			
			if(!reservaService.reservaExists(militarForm.getReserva())) {
				bindingResult.rejectValue("reserva", "error.reserva", "reserva não encontrada");
			}			
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("militar/cadastrar_militar");
			} else {
				Militar militar = new Militar();
				militar.setPosto(militarPostoService.findPostoById(militarForm.getPosto()));
				militar.setReserva(reservaService.findById(militarForm.getReserva()));
				militar.setNomeGuerra(militarForm.getNomeGuerra());
				militar.setUsuario(null);
				if(militarForm.getUsuario() != null && militarForm.getUsuario() > 0) {
					militar.setUsuario(usuarioService.findById(militarForm.getUsuario()));
				}
				militarService.save(militar);
				mv.setViewName("redirect:/militar");
			}
		}
		return mv;		
	}
	
	@GetMapping("/militar/editar")
	public ModelAndView editarMilitar(@RequestParam("id") String militarId)
	{
		mv.setViewName("redirect:/militar");
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(StringUtils.isNumeric(militarId)) {
			Militar militar = militarService.findById(Integer.parseInt(militarId));
			if(militar != null) {
				mv.addObject("militarForm", MilitarForm.factoryMilitarForm(militar));
				mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
				if(militar.getUsuario() != null) {
					mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(Arrays.asList(militar.getUsuario())));
				} else {
					mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(usuarioService.findUsuarioNotMilitar()));
				}
				mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
				mv.setViewName("militar/editar_militar");	
			}
		}
		return mv;
	}
	
	@PostMapping("militar/editar")
	public ModelAndView editarMilitarForm(@Valid MilitarForm militarForm, BindingResult bindingResult)
	{
		mv.addObject("militarForm", militarForm);
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		Militar militar = militarService.findById(militarForm.getId());
		if(militar != null) {
			mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
			if(militar.getUsuario() != null) {
				mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(Arrays.asList(militar.getUsuario())));
			} else {
				mv.addObject("usuarioSelect", UsuarioForm.generateUsuarioSelect(usuarioService.findUsuarioNotMilitar()));
			}
			mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
			mv.setViewName("militar/editar_militar");	
			
			Usuario usuario = null;
			if(militarForm.getUsuario() != null && militarForm.getUsuario() > 0) {			
				usuario = usuarioService.findById(militarForm.getUsuario());
				if(usuario == null) {
					bindingResult.rejectValue("usuario", "error.usuario", "Login não existe");
				} else if(militarForm.getUsuario() != usuario.getId() && militarService.militarUsuarioExists(usuario)) {
					bindingResult.rejectValue("usuario", "error.usuario", "Já existe um militar associado a esse login");
				}
			}
			
			if(!militarPostoService.postoExists(militarForm.getPosto())) {
				bindingResult.rejectValue("posto", "error.posto", "posto não encontrado");
			}
			
			if(!reservaService.reservaExists(militarForm.getReserva())) {
				bindingResult.rejectValue("reserva", "error.reserva", "reserva não encontrada");
			}			
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("militar/cadastrar_militar");
			} else {
				militar.setPosto(militarPostoService.findPostoById(militarForm.getPosto()));
				militar.setReserva(reservaService.findById(militarForm.getReserva()));
				militar.setNomeGuerra(militarForm.getNomeGuerra());
				militar.setUsuario(usuario);
				militarService.save(militar);
				mv.setViewName("redirect:/militar");
			}
		} else {
			mv.setViewName("redirect:/militar");
		}
		return mv;
	}
	
}
