package br.ufba.dcc.quartel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.services.SecurityService;

@Controller
public class BaseController 
{
	protected ModelAndView mv;
	
    @Autowired
    protected SecurityService securityService;
	
	public BaseController()
	{
		super();
		mv = new ModelAndView();
		mv.addObject("hideMenu",false);
	}
}
