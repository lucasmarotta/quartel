package br.ufba.dcc.quartel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufba.dcc.quartel.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	
	Usuario findById(Integer id);
	Usuario findByAtivoTrueAndId(Integer id);
	Usuario findByLogin(String login);
	Usuario findByAtivoTrueAndLogin(String login);
	List<Usuario> findByLoginNot(String login);
	
	@Query(value = "SELECT u.* FROM usuario u LEFT JOIN militar m ON u.id = m.id_usuario WHERE m.id_usuario IS NULL AND u.login != 'root'", nativeQuery=true)
	List<Usuario> findUsuarioNotMilitarQuery();	
}
