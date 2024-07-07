package com.porasl.contentServices.config;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
	import io.swagger.v3.oas.models.info.Contact;
	import io.swagger.v3.oas.models.info.Info;
	import io.swagger.v3.oas.models.info.License;
	import io.swagger.v3.oas.models.servers.Server;

	@EnableWebMvc
	@Configuration
	public class OpenAPIConfig {

	  @Value("${porasl.openapi.dev-url}")
	  private String devUrl;

	  @Value("${porasl.openapi.prod-url}")
	  private String prodUrl;

	  @Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Server URL in Production environment");

	    Contact contact = new Contact();
	    contact.setEmail("hamid@porasl.com");
	    contact.setName("Hamid");
	    contact.setUrl("https://localhost:8080");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("Tutorial Management API")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
	        .license(mitLicense);

	    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	  }
	}
