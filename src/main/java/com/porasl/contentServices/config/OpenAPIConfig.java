package com.porasl.contentservices.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                //.openapi("3.0.3")  // Specify OpenAPI version here
                .info(new Info()
                        .title("File Upload API")
                        .version("1.0.0")
                        .description("API for uploading files")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Support Team").email("support@example.com").url("http://example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
