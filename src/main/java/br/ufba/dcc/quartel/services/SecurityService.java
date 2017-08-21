package br.ufba.dcc.quartel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.ufba.dcc.quartel.models.Usuario;

@Service
public class SecurityService 
{
	@Autowired
	protected UsuarioService usuarioService;
	
    @Autowired
    private AuthenticationManager authenticationManager;	
	
    @Autowired
    private UserDetailsServiceImpl userDetailsService;		
	
	
	public Usuario getLoggedUsuario()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		if(login != null) {
			return usuarioService.findUsuarioByLogin(auth.getName());
		}
		return null;
	}
	
	public void authUser(String username, String pass, boolean reLog)
	{
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, pass, userDetails.getAuthorities());
        if(reLog) {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (usernamePasswordAuthenticationToken.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }        	
        } else {
        	SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
	}	
}
