package com.arquimentor.platform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenapiConfiguration {
    @Bean
    //cofiguracion de swagger-ui
    public OpenAPI arquimentorPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Arquimentor Platform API")
                        .description("Arquimentor Platform application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Arquimentor Platform wiki Documentation")
                        .url("https://arquimentor-platform.wiki.github.io/docs"));
    }
}
