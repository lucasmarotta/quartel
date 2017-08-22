package br.ufba.dcc.quartel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.repositories.UsuarioRepository;
import br.ufba.dcc.quartel.utils.CypherPassEncoder;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private CypherPassEncoder encoder;
	
	public Usuario findUsuarioById(Integer id)
	{
		return usuarioRepo.findById(id);
	}
	
	public Usuario findUsuarioByLogin(String login)
	{
		return usuarioRepo.findByLogin(login);
	}
	
	public List<Usuario> findAll()
	{
		return usuarioRepo.findByLoginNot("rootd");
	}
	
	public List<Usuario> findUsuarioNotMilitar()
	{
		return usuarioRepo.findUsuarioNotMilitarQuery();	
	}	
	
	public boolean usuarioExists(String login)
	{
		return usuarioRepo.findByLogin(login) != null ? true:false;
	}
	
	public long countUsuarios()
	{
		return usuarioRepo.count();
	}
	
	public void save(Usuario usuario)
	{
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario.setAtivo(true);
		usuarioRepo.save(usuario);
	}
}
