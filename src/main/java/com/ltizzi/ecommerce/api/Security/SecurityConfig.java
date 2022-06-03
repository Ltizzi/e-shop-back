
package com.ltizzi.ecommerce.api.Security;

import com.ltizzi.ecommerce.api.Filter.CustomAuthenticationFilter;
import com.ltizzi.ecommerce.api.Filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final UserDetailsService userDetailsServ;
    private final BCryptPasswordEncoder bCryptPassEnc;

    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers(GET, "/productos/**");
       web.ignoring().antMatchers(POST, "/user/new/**");
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServ).passwordEncoder(bCryptPassEnc);
    }
    
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            CustomAuthenticationFilter caf = new CustomAuthenticationFilter(authenticationManagerBean());
            caf.setFilterProcessesUrl("/api/login");
            http.cors().and().csrf().disable();
            http.anonymous();
            http.authorizeHttpRequests().antMatchers("/**").permitAll()
                                                         .anyRequest().authenticated();
            http.addFilter(caf)
                  .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    
    
}
