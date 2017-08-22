package br.ufba.dcc.quartel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.Militar;

public interface MilitarRepository extends JpaRepository<Militar, Long>
{
	Militar findById(Integer id);
	List<Militar> findByNomeGuerra(String nomeGuerra);
	List<Militar> findByUsuarioIdNotNull();
	Militar findByUsuarioId(Integer idUsuario);
}
