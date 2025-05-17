package com.porasl.contentservices.config;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
    	 return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/contents")
         .username("root")
         .password("passw0rd")
         .driverClassName("com.mysql.cj.jdbc.Driver")
         .build();
    }

    @Bean(name = "liquibaseDataSource")
    @LiquibaseDataSource
    @ConfigurationProperties(prefix = "spring.liquibase.datasource")
    public DataSource liquibaseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }
}
