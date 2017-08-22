package br.ufba.dcc.quartel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.forms.ArmamentoForm;
import br.ufba.dcc.quartel.forms.ReservaForm;
import br.ufba.dcc.quartel.services.ArmamentoService;
import br.ufba.dcc.quartel.services.ReservaService;

@Controller
public class ArmamentoController extends BaseController
{
	@Autowired
	private ArmamentoService armamentoService;
	
	@Autowired
	private ReservaService reservaService;
	
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
}
