package com.porasl.contentservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SecurityBeansConfig {
	
	private final UserDetailsService userDetailsService = null;

	   @Bean(name = "contentServiceAuthenticationProvider")
	    public DaoAuthenticationProvider getAuthenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return authProvider;
	    }
}
