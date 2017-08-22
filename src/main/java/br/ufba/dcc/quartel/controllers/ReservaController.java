package br.ufba.dcc.quartel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.ReservaService;

@Controller
public class ReservaController extends BaseController
{
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/reserva")
	public ModelAndView listarReserva()
	{
		ModelAndView mv = new ModelAndView();
		Usuario usuario = securityService.getLoggedUsuario();
		mv.addObject("usuario", usuario.getNome());
		mv.addObject("reservas", reservaService.findAll());
		mv.setViewName("reserva/listar_reserva");
		return mv;
	}
}
