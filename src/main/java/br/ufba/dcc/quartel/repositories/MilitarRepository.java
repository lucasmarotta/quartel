package br.ufba.dcc.quartel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufba.dcc.quartel.models.Militar;
import br.ufba.dcc.quartel.models.Usuario;

public interface MilitarRepository extends JpaRepository<Militar, Long>
{
	List<Militar> findByNomeGuerra(String nomeGuerra);
	List<Militar> findByUsuarioIdNotNull();
	Militar findByUsuarioId(Integer idUsuario);
}
