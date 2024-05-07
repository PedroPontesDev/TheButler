package com.br.trentor.TheButler.configs;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI swaggerConfig() {
		return new OpenAPI()
					.info(new Info()
							.title("O Mordomo, WebService Focado Na Gestão de Restaurantes!")
							.version("v1")
							.description("Aplicação focada em ajudar restuarantes de todos os portes!"));
	}
	
}
