
package com.ltizzi.ecommerce.api.Filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Service.IUsuarioService;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    private final AuthenticationManager authMng;
    

    
    public CustomAuthenticationFilter (AuthenticationManager authMng) {
        this.authMng = authMng;
    }
    
    public CustomAuthenticationFilter() {
        throw new UnsupportedOperationException("Todavía no soportado");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contraseña");
        
        log.info("Logueando con el usuario {}", usuario);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuario, password);
        return authMng.authenticate(authToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {

        User user = (User)authentication.getPrincipal();
               
        Algorithm algorithm = Algorithm.HMAC256("B9DC76682CB9F59112736865F5613".getBytes());
        
        String token = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                    .withIssuer(request.getRequestURI())
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
        
        response.setHeader("token", token);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), token);
                
         }
    
   
}
