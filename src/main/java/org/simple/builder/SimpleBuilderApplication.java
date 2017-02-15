package org.simple.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

@SpringBootApplication
@EnableEntityLinks
public class SimpleBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBuilderApplication.class, args);
	}
}
