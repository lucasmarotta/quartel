package br.ufba.dcc.quartel.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.ufba.dcc.quartel.utils.CypherPassEncoder;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	@Bean
	public CypherPassEncoder passwordEncoder()
	{
		return new CypherPassEncoder();
	}
}
