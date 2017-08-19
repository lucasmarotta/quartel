package br.ufba.dcc.quartel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"br.ufba.dcc.quartel.app", "br.ufba.dcc.quartel.controllers",})
@EnableJpaRepositories("br.ufba.dcc.quartel.repositories")
@EntityScan("br.ufba.dcc.quartel.models")
@SpringBootApplication
public class WebApp {

	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}
}
