package com.example.Foro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    public OpenAPI customOpenApi(){
        return  new OpenAPI()
                .info(new Info()
                        .title("Api Gestion de Foro")
                        .version("1.0.0")
                        .description("Documentacion "));
    }
}
