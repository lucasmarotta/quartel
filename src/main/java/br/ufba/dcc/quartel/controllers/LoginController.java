package br.ufba.dcc.quartel.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class LoginController extends BaseController
{
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private MilitarService militarService;
	
	@Autowired
	private MilitarPostoService militarPostoService;
	
	@GetMapping({"/", "/login"})
	public ModelAndView login()
	{
		mv.addObject("hideMenu", true);
		
		//Se só tiver o root o usuário será levado a uma tela de configuração inicial
		if(usuarioService.countUsuarios() == 1) {
			mv.addObject("usuarioForm", new UsuarioForm());
			mv.setViewName("usuario/cadastrar_usuario");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}
	
	@PostMapping("/login/registra_usuario_inicial")
	public ModelAndView registraUsuarioInicialForm(@Valid UsuarioForm usuarioForm, BindingResult bindingResult)
	{
		mv.addObject("hideMenu", true);
		mv.addObject("usuarioForm", usuarioForm);
		if(usuarioService.usuarioExists(usuarioForm.getLogin())) {
			bindingResult.rejectValue("login", "error.login", "Usuário já existente. Escolha outro login");
		} else if(!usuarioForm.checkSenha()) {
			bindingResult.rejectValue("senha", "error.senha", "Senha e confirmação de senha divergem");
			bindingResult.rejectValue("senhaConfirma", "error.confirmaSenha", "Senha e confirmação de senha divergem");
		}
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("usuario/cadastrar_usuario");
		} else {
			Usuario usuario = usuarioForm.generateUsuario();
			usuarioService.save(usuario);
			securityService.authUser(usuario.getLogin(), usuario.getSenha(), false);
			mv.setViewName("redirect:/login/registra_reserva_inicial");
		}
		return mv;
	}
	
	@GetMapping("/login/registra_reserva_inicial")
	public ModelAndView registraReservaInicial()
	{
		mv.addObject("hideMenu", true);
		mv.addObject("reservaForm", new ReservaForm());
		mv.setViewName("reserva/cadastrar_reserva");
		return mv;
	}
	
	@PostMapping("/login/registra_reserva_inicial")
	public ModelAndView registraReservaInicialForm(@Valid ReservaForm reservaForm, BindingResult bindingResult)
	{
		mv.addObject("hideMenu", true);
		mv.addObject("reservaForm", reservaForm);
		if(reservaService.reservaExists(reservaForm.getSigla())) {
			bindingResult.rejectValue("sigla", "error.sigla", "Reserva já existente. Escolha outra sigla");
		}
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("reserva/cadastrar_reserva");
		} else {
			reservaService.save(reservaForm.generateReserva());
			mv.setViewName("redirect:/login/registra_militar_inicial");
		}
		return mv;
	}
	
	@GetMapping("/login/registra_militar_inicial")
	public ModelAndView registraMilitarInicial()
	{
		mv.addObject("hideMenu", true);
		mv.addObject("militarForm", new MilitarForm());
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		Map<String, String> usuarioSelect = UsuarioForm.generateUsuarioSelect(Arrays.asList(securityService.getLoggedUsuario()));
		usuarioSelect.remove("0");
		mv.addObject("usuarioSelect", usuarioSelect);
		mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
		mv.setViewName("militar/cadastrar_militar");
		return mv;
	}
	
	@PostMapping("/login/registra_militar_inicial")
	public ModelAndView registraMilitarInicialForm(@Valid MilitarForm militarForm, BindingResult bindingResult)
	{
		mv.addObject("hideMenu", true);
		mv.addObject("militarForm", militarForm);
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		Map<String, String> usuarioSelect = UsuarioForm.generateUsuarioSelect(Arrays.asList(securityService.getLoggedUsuario()));
		usuarioSelect.remove("0");
		mv.addObject("usuarioSelect", usuarioSelect);
		mv.addObject("postoSelect", MilitarForm.generatePostoSelect(militarPostoService.findAll()));
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("militar/cadastrar_militar");
		} else {
			
			if(militarForm.getUsuario() != null && militarForm.getUsuario() > 0) {			
				Usuario usuario = usuarioService.findUsuarioById(militarForm.getUsuario());
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
					militar.setUsuario(usuarioService.findUsuarioById(militarForm.getUsuario()));
				}
				militarService.save(militar);
				mv.setViewName("redirect:/logout");
			}
		}
		return mv;
	}
	
	@GetMapping("acesso_negado")
	@ResponseBody
	public String acessoNegado()
	{
		return "Acesso Negado";
	}
	
	/* 
	@GetMapping("/teste")
	public String teste(Map<String, Object> model)
	{
		
		Usuario usuario = new Usuario();
		usuario.setLogin("test");
		usuario.setNome("Testando");
		usuario.setSalt("123456");
		usuario.setSenha("132965494");
		usuario.setEmail("test@mail.com");
		usuarioRepository.save(usuario);
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("item 1");
		test.add("item 2");
		model.put("test", test);
		return "login";
	}
	*/
}
