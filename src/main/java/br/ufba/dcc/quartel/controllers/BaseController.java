package br.ufba.dcc.quartel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.UsuarioService;

public class BaseController 
{
	@Autowired
	protected UsuarioService usuarioService;
	
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
