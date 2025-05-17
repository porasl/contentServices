package com.porasl.contentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.porasl.contentservices"})
@EntityScan(basePackages = {"com.porasl.contentservices.domain"})
public class ContentservicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentservicesApplication.class, args);
    }
}
