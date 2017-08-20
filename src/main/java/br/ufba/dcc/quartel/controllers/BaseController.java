package br.ufba.dcc.quartel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.UsuarioService;

public class BaseController 
{
	@Autowired
	protected UsuarioService usuarioService;
	protected ModelAndView mv;
	
	public BaseController()
	{
		super();
		mv = new ModelAndView();
		mv.addObject("hideMenu",false);
	}
	
	protected Usuario getLoggedUsuario()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		if(login != null) {
			return usuarioService.findUsuarioByLogin(auth.getName());
		}
		return null;
	}
}
