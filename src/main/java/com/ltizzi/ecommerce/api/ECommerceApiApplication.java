package com.ltizzi.ecommerce.api;

import com.ltizzi.ecommerce.api.Model.Rol;
import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Service.IUsuarioService;
import org.springframework.boot.CommandLineRunner;
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
                                                                            .allowedOrigins("https://e-shop-ltizzi.web.app"); 
			}
		};
	}
        
                @Bean
                PasswordEncoder passwordEncoder() {
                    return new BCryptPasswordEncoder();
                }
                
                @Bean
                CommandLineRunner run (IUsuarioService userServ) {
                    return args -> {
//                        userServ.saveRol(new Rol(null, "ROL_USER"));
//                        userServ.saveRol(new Rol(null, "ROL_ADMIN"));
//                        userServ.saveRol(new Rol(null, "ROL_SUPERADMIN"));
////                        
//                        userServ.addRolToUser("ltizzi", userServ.getRol(
//                                2L));
//                        userServ.addRolToUser("ltizzi", userServ.getRol(
//                                3L));
//                          Usuario ltizzi = userServ.getUsuario(37L);
//                          BCryptPasswordEncoder pass = (BCryptPasswordEncoder) passwordEncoder();
//                          String password = pass.encode("password").toString();
//                          ltizzi.setPassword(password);
//                          userServ.editUsuario(ltizzi);
                    };
                }

}
