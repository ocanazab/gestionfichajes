package com.sanvalero.nacho.gestionfichajes.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GestionFichajesConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("GestionFichajes API")
                        .description("Obtención de información del sistema de fichajes")
                        .contact(new Contact()
                                .name("José Ignacio Bazán")
                                .email("a23893@svalero.com")
                                )
                        .version("1.0"));
    }
}
