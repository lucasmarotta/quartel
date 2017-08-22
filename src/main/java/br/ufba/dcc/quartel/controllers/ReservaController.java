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

import br.ufba.dcc.quartel.forms.ReservaForm;
import br.ufba.dcc.quartel.models.Reserva;
import br.ufba.dcc.quartel.services.ReservaService;

@Controller
public class ReservaController extends BaseController
{
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/reserva")
	public ModelAndView listarReserva()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("reservas", reservaService.findAll());
		mv.setViewName("reserva/listar_reserva");
		return mv;
	}
	
	@GetMapping("/reserva/cadastrar")
	public ModelAndView cadastrarReserva()
	{
		mv.addObject("reservaForm", new ReservaForm());
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.setViewName("reserva/cadastrar_reserva");
		return mv;
	}
	
	
	@PostMapping("/reserva/cadastrar")
	public ModelAndView cadastrarReservaForm(@Valid ReservaForm reservaForm, BindingResult bindingResult)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(bindingResult.hasErrors()) {
			mv.setViewName("reserva/cadastrar_reserva");
		} else {
			mv.addObject("reservaForm", reservaForm);
			if(reservaService.reservaExists(reservaForm.getSigla())) {
				bindingResult.rejectValue("sigla", "error.sigla", "Reserva já existente. Escolha outra sigla");
			}			
			
			if(!bindingResult.hasErrors()) {
				reservaService.save(reservaForm.generateReserva());
				mv.setViewName("redirect:/reserva");
			}
		}
		return mv;
	}	
	
	@GetMapping("/reserva/editar")
	public ModelAndView editarReserva(@RequestParam("id") String reservaId)
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.setViewName("redirect:/reserva");
		if(StringUtils.isNumeric(reservaId)) {
			Reserva reserva = reservaService.findById(Integer.parseInt(reservaId));
			if(reserva != null) {
				mv.addObject("reservaForm", reserva);
				mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
				mv.setViewName("reserva/editar_reserva");	
			}
		}
		return mv;
	}
	
	@PostMapping("/reserva/editar")
	public ModelAndView editarReservaForm(@Valid ReservaForm reservaForm, BindingResult bindingResult)
	{
		mv.addObject("reservaForm", reservaForm);
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(bindingResult.hasErrors()) {
			mv.setViewName("reserva/editar_reserva");
		} else {
			
			Reserva reserva = reservaService.findById(reservaForm.getId());
			if(reserva != null) {
				if(!reserva.getSigla().equals(reservaForm.getSigla())) {
					if(reservaService.reservaExists(reservaForm.getSigla())) {
						bindingResult.rejectValue("sigla", "error.sigla", "Reserva já existente. Escolha outra sigla");
					}		
				}				
			}
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("/reserva/editar_reserva");
			} else {
				reservaService.save(reservaForm.generateReserva());
				mv.setViewName("redirect:/reserva");
			}
		}
		return mv;
	}		
}
