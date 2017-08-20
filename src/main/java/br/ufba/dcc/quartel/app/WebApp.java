package br.ufba.dcc.quartel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"br.ufba.dcc.quartel.app", "br.ufba.dcc.quartel.controllers", "br.ufba.dcc.quartel.services"})
@EnableJpaRepositories("br.ufba.dcc.quartel.repositories")
@EntityScan("br.ufba.dcc.quartel.models")
@SpringBootApplication
public class WebApp implements EmbeddedServletContainerCustomizer 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(WebApp.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) 
	{
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        container.setMimeMappings(mappings);		
	}
}
