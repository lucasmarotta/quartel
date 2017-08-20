package br.ufba.dcc.quartel.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CypherPassEncoder implements PasswordEncoder 
{
	@Override
	public String encode(CharSequence rawPassword) 
	{
		return CypherUtil.hashSecret(String.valueOf(rawPassword));
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) 
	{
		return CypherUtil.checkHashSecret(encodedPassword, String.valueOf(rawPassword));
	}
}
