package com.ltizzi.ecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ECommerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApiApplication.class, args);
	}
        
            
                    @Bean
        	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
                                                                            .allowedHeaders("*")
                                                                            .allowedMethods("*")
                                                                            .allowCredentials(false)
                                                                            .allowedOrigins("*"); 
			}
		};
	}
        
                @Bean
                PasswordEncoder passwordEncoder() {
                    return new BCryptPasswordEncoder();
                }

}
