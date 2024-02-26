package com.example.application.service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("news service API")
                .version("1.0.0")
                .description("Rest documentation for Rest endpoints of News Service"));
    }
}
