package br.ufba.dcc.quartel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.models.Usuario;

@Controller
public class ReservaController extends BaseController
{
	@GetMapping("/reserva")
	public ModelAndView listarReserva()
	{
		ModelAndView mv = new ModelAndView();
		Usuario usuario = securityService.getLoggedUsuario();
		mv.addObject("usuario", usuario);
		mv.setViewName("reserva/listar_reserva");
		return mv;
	}
}
