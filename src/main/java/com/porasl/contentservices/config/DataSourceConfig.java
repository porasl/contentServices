package com.porasl.contentservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .url("jdbc:mysql://localhost:3306/users")
            .username("root")
            .password("passw0rd")
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .build();
    }
}
