package com.porasl.contentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.porasl.contentservices","com.porasl.authservices"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"com.porasl.authservices.user", "com.porasl.authservices.token"})

public class ContentservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentservicesApplication.class, args);
	}
}

