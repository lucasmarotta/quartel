package br.ufba.dcc.quartel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.TipoMaterial;

public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long>
{
	TipoMaterial findById(Integer id);
}
