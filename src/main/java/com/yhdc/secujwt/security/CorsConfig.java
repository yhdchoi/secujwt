package com.yhdc.secujwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // Allowing Javascript to process server's JSON response
		config.addAllowedOrigin("*"); // All IP
		config.addAllowedHeader("*"); 
		config.addAllowedMethod("*"); // All POST,GET,PUT,DELETE, PATCH
		source.registerCorsConfiguration("/api/**", config);
		
		return new CorsFilter(source);
	}
}
