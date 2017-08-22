package br.ufba.dcc.quartel.controllers;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.forms.ArmamentoForm;
import br.ufba.dcc.quartel.forms.ReservaForm;
import br.ufba.dcc.quartel.models.Armamento;
import br.ufba.dcc.quartel.models.TipoMaterialEnum;
import br.ufba.dcc.quartel.services.ArmamentoService;
import br.ufba.dcc.quartel.services.ReservaService;
import br.ufba.dcc.quartel.services.TipoMaterialService;

@Controller
public class ArmamentoController extends BaseController
{
	@Autowired
	private ArmamentoService armamentoService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private TipoMaterialService tipoMaterialService;
	
	@GetMapping("/armamento")
	public ModelAndView listarArmamento()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("armamentos", armamentoService.findAll());
		mv.setViewName("armamento/listar_armamento");
		return mv;
	}
	
	@GetMapping("/armamento/cadastrar")
	public ModelAndView cadastrarArmamento()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("armamentoForm", new ArmamentoForm());
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		mv.setViewName("armamento/cadastrar_armamento");
		return mv;
	}
	
	@PostMapping("/armamento/cadastrar")
	public ModelAndView cadastrarArmamentoForm(@Valid ArmamentoForm armamentoForm, BindingResult bindingResult)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("armamentoForm", armamentoForm);
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("armamento/cadastrar_armamento");
		} else {
			
			if(!reservaService.reservaExists(armamentoForm.getReserva())) {
				bindingResult.rejectValue("reserva", "error.reserva", "reserva não encontrada");
			}
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("armamento/cadastrar_armamento");
			} else {
				Armamento armamento = new Armamento();
				armamento.setAtivo(true);
				armamento.setFabricante(armamentoForm.getFabricante());
				armamento.setModelo(armamentoForm.getModelo());
				armamento.setReserva(reservaService.findById(armamentoForm.getReserva()));
				armamento.setSerie(armamentoForm.getSerie());
				armamento.setUsuario(securityService.getLoggedUsuario());
				armamento.setTipoMaterial(tipoMaterialService.findById(TipoMaterialEnum.ARMAMENTO.value));
				armamento.setQtd(1);
				armamentoService.save(armamento);
				mv.setViewName("redirect:/armamento");
			}	
		}
		return mv;
	}
	
	@GetMapping("armamento/editar")
	public ModelAndView editarArmamento(@RequestParam("id") String idMaterial)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(StringUtils.isNumeric(idMaterial)) {
			Armamento armamento = armamentoService.findById(Integer.parseInt(idMaterial));
			if(armamento != null) {
				mv.addObject("armamentoForm", ArmamentoForm.factoryArmamentoForm(armamento));
				mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
				mv.setViewName("armamento/editar_armamento");
			}
		}
		return mv;
	}
	
	@PostMapping("/armamento/editar")
	public ModelAndView editarArmamentoForm(@Valid ArmamentoForm armamentoForm, BindingResult bindingResult)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("armamentoForm", armamentoForm);
		mv.addObject("reservaSelect", ReservaForm.generateReservaSelect(reservaService.findAll()));
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("armamento/editar_armamento");
		} else {
			
			if(!reservaService.reservaExists(armamentoForm.getReserva())) {
				bindingResult.rejectValue("reserva", "error.reserva", "reserva não encontrada");
			}
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("armamento/editar_armamento");
			} else {
				Armamento armamento = new Armamento();
				armamento.setAtivo(true);
				armamento.setId(armamentoForm.getId());
				armamento.setFabricante(armamentoForm.getFabricante());
				armamento.setModelo(armamentoForm.getModelo());
				armamento.setReserva(reservaService.findById(armamentoForm.getReserva()));
				armamento.setSerie(armamentoForm.getSerie());
				armamento.setUsuario(securityService.getLoggedUsuario());
				armamento.setTipoMaterial(tipoMaterialService.findById(TipoMaterialEnum.ARMAMENTO.value));
				armamento.setQtd(1);
				armamentoService.save(armamento);
				mv.setViewName("redirect:/armamento");
			}	
		}
		return mv;
	}
	
	@GetMapping("armamento/deletar")
	public ModelAndView deletarArmamento(@RequestParam("id") String idMaterial)
	{
		if(StringUtils.isNumeric(idMaterial)) {
			Armamento armamento = armamentoService.findById(Integer.parseInt(idMaterial));
			if(armamento != null) {
				armamentoService.toggleArmamentoAtivo(armamento);
				mv.setViewName("redirect:/armamento");
			}
		}
		return mv;		
	}
}
