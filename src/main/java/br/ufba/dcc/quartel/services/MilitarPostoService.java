package br.ufba.dcc.quartel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.MilitarPosto;
import br.ufba.dcc.quartel.repositories.MilitarPostoRepository;

@Service
public class MilitarPostoService 
{
	@Autowired
	MilitarPostoRepository militarPostoRepo;
	
	public MilitarPosto findPostoByNome(String nome)
	{
		return militarPostoRepo.findByNome(nome);
	}
	
	public MilitarPosto findPostoById(Integer id)
	{
		return militarPostoRepo.findById(id);
	}
	
	public boolean postoExists(String nome)
	{
		return (militarPostoRepo.findByNome(nome) != null) ? true:false;
	}
	
	public boolean postoExists(Integer id)
	{
		return (militarPostoRepo.findById(id) != null) ? true:false;
	}	
	
	public List<MilitarPosto> findAll()
	{
		return militarPostoRepo.findAllByOrderByIdAsc();
	}
}
