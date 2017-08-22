package br.ufba.dcc.quartel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Militar;
import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.repositories.MilitarRepository;

@Service
public class MilitarService 
{
	@Autowired
	private MilitarRepository militarRepo;
	
	public List<Militar> findByNomeGuerra(String nomeGuerra)
	{
		return militarRepo.findByNomeGuerra(nomeGuerra);
	}
	
	public List<Militar> findByMilitarUsuarioNotNull()
	{
		return militarRepo.findByUsuarioIdNotNull();
	}
	
	public List<Usuario> findUsuarioMilitar()
	{
		List<Militar> militares = findByMilitarUsuarioNotNull();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(militares != null) 
		{
			for (Militar militar : militares) 
			{
				usuarios.add(militar.getUsuario());
			}			
		}
		return usuarios;
	}
	
	public boolean militarUsuarioExists(Usuario usuario)
	{
		if(usuario != null) {
			return (militarRepo.findByUsuarioId(usuario.getId()) == null) ? false:true;
		}
		return false;	
	}
	
	public void save(Militar militar)
	{
		militarRepo.save(militar);
	}
}
