package br.ufba.dcc.quartel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ufba.dcc.quartel.forms.UsuarioForm;
import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.services.UsuarioService;

@Controller
public class LoginController extends BaseController
{
	@Autowired
	protected UsuarioService usuarioService;
	
	@GetMapping({"/", "/login"})
	public ModelAndView login()
	{
		mv.addObject("hideMenu", true);
		
		//Se só tiver o root o usuário será levado a uma tela de configuração inicial
		if(usuarioService.countUsuarios() == 1) {
			mv.addObject("usuarioForm", new UsuarioForm());
			mv.setViewName("usuario/cadastra_usuario");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}
	
	@GetMapping("/login/registra_usuario_inicial")
	public ModelAndView registraUsuarioInicial()
	{
		mv.addObject("hideMenu", true);
		mv.setViewName("usuario/cadastra_usuario");
		mv.addObject("usuarioForm", new UsuarioForm());
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
			mv.setViewName("usuario/cadastra_usuario");
		} else {
			Usuario usuario = usuarioForm.generateUsuario();
			usuarioService.save(usuario);
			securityService.authUser(usuario.getLogin(), usuario.getSenha(), false);
			mv.setViewName("redirect:/login/registra_militar_inicial");
		}
		return mv;
	}
	
	@GetMapping("/login/registra_militar_inicial")
	public ModelAndView registraMilitarInicial()
	{
		mv.addObject("hideMenu", true);
		mv.addObject("usuarioForm", new UsuarioForm());
		mv.setViewName("militar/cadastra_militar");
		return mv;
	}
	
	@PostMapping("/login/registra_militar_inicial")
	public ModelAndView registraMilitarInicialForm(@Valid UsuarioForm usuarioForm, BindingResult bindingResul)
	{
		mv.addObject("hideMenu", true);
		mv.addObject("usuarioForm", usuarioForm);
		mv.setViewName("militar/cadastra_militar");
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
