package br.ufba.dcc.quartel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Armamento;
import br.ufba.dcc.quartel.models.TipoMaterialEnum;
import br.ufba.dcc.quartel.repositories.ArmamentoRepository;

@Service
public class ArmamentoService 
{
	@Autowired
	private ArmamentoRepository armamentoRepo;
	
	public Armamento findById(Integer id)
	{
		return armamentoRepo.findById(id);
	}
	
	public List<Armamento> findAll()
	{
		return armamentoRepo.findByTipoMaterialId(TipoMaterialEnum.ARMAMENTO.value);
	}
	
	public void toggleArmamentoAtivo(Armamento armamento)
	{
		if(armamento.getAtivo()) armamento.setAtivo(false);
		else armamento.setAtivo(true);
		armamentoRepo.save(armamento);
	}
	
	public void save(Armamento armamento)
	{
		armamentoRepo.save(armamento);
	}
}
