package br.ufba.dcc.quartel.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController extends BaseController
{
	@GetMapping({"/", "/login"})
	public String login()
	{
		//Se só tiver o root o usuário será levado a uma tela de configuração inicial
		/*if(usuarioService.countUsuarios() == 1) {
			return "home_registro";
		} else {
			return "login";
		}*/
		return "login";
	}
	
	@GetMapping("acesso_negado")
	@ResponseBody
	public String acessoNegado()
	{
		return "Acesso Negado";
	}
	
	@GetMapping("/teste")
	public String teste(Map<String, Object> model)
	{
		
		/*Usuario usuario = new Usuario();
		usuario.setLogin("test");
		usuario.setNome("Testando");
		usuario.setSalt("123456");
		usuario.setSenha("132965494");
		usuario.setEmail("test@mail.com");
		usuarioRepository.save(usuario);*/
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("item 1");
		test.add("item 2");
		model.put("test", test);
		return "login";
	}
}
