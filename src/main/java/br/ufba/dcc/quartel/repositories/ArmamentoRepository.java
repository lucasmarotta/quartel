package br.ufba.dcc.quartel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.Armamento;

public interface ArmamentoRepository extends JpaRepository<Armamento, Long>
{
	Armamento findById(Integer id);
	List<Armamento> findByTipoMaterialId(Integer id);
}
