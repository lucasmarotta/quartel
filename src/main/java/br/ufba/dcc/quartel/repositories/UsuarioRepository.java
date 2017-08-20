package br.ufba.dcc.quartel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.dcc.quartel.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	Usuario findByLogin(String login);
}
