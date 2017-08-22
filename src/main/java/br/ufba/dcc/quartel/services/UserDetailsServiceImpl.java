package br.ufba.dcc.quartel.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Usuario;
import br.ufba.dcc.quartel.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
    @Autowired
    private UsuarioRepository usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Usuario usuario = usuarioRepo.findByAtivoTrueAndLogin(username);
		if(usuario != null) {
			Set<GrantedAuthority> authorities = new HashSet<>();
			return new User(usuario.getLogin(), usuario.getSenha(), authorities);			
		} else {
			throw new UsernameNotFoundException(String.format("Usuário %s não encontrado", username));
		}
	}

}
