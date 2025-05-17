package com.porasl.contentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {LiquibaseAutoConfiguration.class})
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.porasl.contentservices"})
@EntityScan(basePackages = {"com.porasl.contentservices.domain"})
@EnableJpaRepositories(basePackages = {"com.porasl.contentservices.repository"})

public class ContentservicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentservicesApplication.class, args);
    }
}
