package com.springemp.swaggerconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI userOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Spring Boot Boilerplate Project")
						.description("Spring Boot Boilerplate is a starter kit. This project includes : Spring Boot(3.0.6), Spring Data JPA, Spring Validation, Spring Security + JWT Token, mySQL, Lombok, Swagger")
						.version("3.0")
						.contact(new Contact()
								.name("TMO InApp")
								.email("tmo@inapp.com")
								));
	}
}
