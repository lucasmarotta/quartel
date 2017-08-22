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

import br.ufba.dcc.quartel.forms.UsuarioEditForm;
import br.ufba.dcc.quartel.forms.UsuarioForm;
import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.UsuarioService;

@Controller
public class UsuarioController extends BaseController
{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public ModelAndView listarUsuario()
	{
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.addObject("usuarios", usuarioService.findAll());
		mv.setViewName("usuario/listar_usuario");
		return mv;
	}
	
	@GetMapping("/usuario/cadastrar")
	public ModelAndView cadastarUsuario()
	{
		mv.addObject("usuarioForm", new UsuarioForm());
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		mv.setViewName("usuario/cadastrar_usuario");
		return mv;
	}
	
	@PostMapping("/usuario/cadastrar")
	public ModelAndView cadastrarUsuarioForm(@Valid UsuarioForm usuarioForm, BindingResult bindingResult)
	{
		mv.addObject("usuarioForm", usuarioForm);
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("usuario/cadastrar_usuario");
		} else {
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
				mv.setViewName("redirect:/usuario");
			}	
		}
		return mv;
	}
	
	@GetMapping("/usuario/editar")
	public ModelAndView editarUsuario(@RequestParam("id") String usuarioId)
	{
		mv.setViewName("redirect:/usuario");
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(StringUtils.isNumeric(usuarioId) && !usuarioId.equals("1")) {
			Usuario usuario = usuarioService.findById(Integer.parseInt(usuarioId));
			if(usuario != null) {
				mv.addObject("usuarioEditForm", UsuarioEditForm.factoryUsuarioForm(usuario));
				mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
				mv.setViewName("usuario/editar_usuario");	
			}
		}
		return mv;	
	}
	
	@PostMapping("/usuario/editar")
	public ModelAndView editarUsuarioForm(@Valid UsuarioEditForm usuarioEditForm, BindingResult bindingResult)
	{
		mv.addObject("usuarioEditForm", usuarioEditForm);
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(bindingResult.hasErrors()) {
			mv.setViewName("usuario/editar_usuario");
		} else {

			Usuario usuario = usuarioService.findById(usuarioEditForm.getId());
			if(usuario != null) {
				if(!usuario.getLogin().equals(usuarioEditForm.getLogin())) {
					if(usuarioService.usuarioExists(usuarioEditForm.getLogin())) {
						bindingResult.rejectValue("login", "error.login", "Usuário já existente. Escolha outro login");
					}				
				}

				if(usuarioEditForm.getSenha().length() > 0) {
					if(!usuarioEditForm.checkSenha()) {
						bindingResult.rejectValue("senha", "error.senha", "Senha e confirmação de senha divergem");
						bindingResult.rejectValue("senhaConfirma", "error.confirmaSenha", "Senha e confirmação de senha divergem");
					}					
				}					
			}
			
			if(bindingResult.hasErrors()) {
				mv.setViewName("usuario/editar_usuario");
			} else {
				Usuario loggedUsuario = securityService.getLoggedUsuario();
				String senha = usuario.getSenha();
				usuario = usuarioEditForm.generateUsuario();
				if(usuarioEditForm.getSenha().length() > 0) {
					usuarioService.update(usuario, true);
				} else {
					usuario.setSenha(senha);
					usuarioService.update(usuario, false);
				}
				
				if(usuario.getId() == loggedUsuario.getId() && usuario.getLogin() != loggedUsuario.getLogin()) {
					mv.setViewName("redirect:/logout");
				} else {
					mv.setViewName("redirect:/usuario");
				}
			}	
		}
		return mv;
	}
	
	@GetMapping("usuario/deletar")
	public ModelAndView deletarUsuario(@RequestParam("id") String usuarioId)
	{
		mv.setViewName("redirect:/usuario");
		mv.addObject("usuario", securityService.getLoggedUsuario().getNome());
		if(StringUtils.isNumeric(usuarioId) && !usuarioId.equals("1")) {
			Usuario usuario = usuarioService.findById(Integer.parseInt(usuarioId));
			if(usuario != null) {
				usuarioService.toggleUsuarioAtivo(usuario);	
			}
		}
		return mv;		
	}
	
}
