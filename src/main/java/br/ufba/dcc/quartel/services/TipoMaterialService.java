package br.ufba.dcc.quartel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.TipoMaterial;
import br.ufba.dcc.quartel.repositories.TipoMaterialRepository;

@Service
public class TipoMaterialService 
{
	@Autowired
	private TipoMaterialRepository tipoMaterialRepository;
	
	public TipoMaterial findById(Integer id) 
	{
		return tipoMaterialRepository.findById(id);
	}
}
