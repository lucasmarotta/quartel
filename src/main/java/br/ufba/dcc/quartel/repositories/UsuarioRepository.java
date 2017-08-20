package br.ufba.dcc.quartel.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufba.dcc.quartel.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>
{
	Usuario findByLogin(String login);
}
