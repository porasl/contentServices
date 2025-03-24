package com.porasl.contentservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration("contentservices")
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi contentservicesApi() {
        return GroupedOpenApi.builder()
            .group("contentservices-api")
            .pathsToMatch("/contentservices/**")
            .build();
    }
}
