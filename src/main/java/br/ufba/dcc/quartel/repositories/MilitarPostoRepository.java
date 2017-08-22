package br.ufba.dcc.quartel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.MilitarPosto;

public interface MilitarPostoRepository extends JpaRepository<MilitarPosto, Long>
{
	MilitarPosto findByNome(String nome);
	MilitarPosto findById(Integer id);
	List<MilitarPosto> findAllByOrderByIdAsc();
}
