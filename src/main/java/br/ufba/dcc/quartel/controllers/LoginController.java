package br.ufba.dcc.quartel.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.repositories.UsuarioRepository;

@Controller
public class LoginController
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String login(Map<String, Object> model)
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
}
