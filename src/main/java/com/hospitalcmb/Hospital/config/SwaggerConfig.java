package com.hospitalcmb.Hospital.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Hospital API").version("1.0").description("Documentação da API do Hospital"))
				// 🔑 Adiciona o requisito de segurança
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				// 🔑 Define o esquema de autenticação JWT (Bearer)
				.components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().name("Authorization").type(SecurityScheme.Type.HTTP).scheme("bearer")
								.bearerFormat("JWT")));
	}

}
