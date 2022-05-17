
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Rol;
import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Repository.RolRepository;
import com.ltizzi.ecommerce.api.Repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsuarioService implements IUsuarioService, UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepo;
    
    private final PasswordEncoder passEnc;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsers = usuarioRepository.findAll();
        return listaUsers;
    }

  
    @Override
    public void saveUsuario(Usuario user) {
        log.info("Guardando el nuevo usuario {} en la base de datos ", user.getUsuario());
        user.setPassword(passEnc.encode(user.getPassword()));
        usuarioRepository.save(user);
    }

    @Override
    public void deleteUsuario(Long id) {
        Usuario user = usuarioRepository.getById(id);
        log.info("Borrando el usuario {} de la base de datos", user.getUsuario() );
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editUsuario(Usuario user) {
        log.info("Editando al usuario {} en la base de datos", user.getUsuario());
        usuarioRepository.save(user);
    }

    @Override
    public Usuario getUsuario(Long id) {
        log.info("Rastreando al usuario de id {}", id);
        Usuario user = usuarioRepository.findById(id).orElse(null);
        return user;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        
        Usuario user = usuarioRepository.findByUsuario(usuario);
        
        if ( user == null) {
            log.error("Usuario no encontrado en la base de datos");
            throw new UsernameNotFoundException("Usuario no encontrado en la base de datos");
        }
        
        else {
            log.info("Usuario encontrado en la base de datos: {}", usuario);
        }
        
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
                                authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        });
        
        return new org.springframework.security.core.userdetails.User(user.getUsuario(),
                                user.getPassword(), authorities);

    }
    
   //Rol
   

    @Override
    public List<Rol> getRoles() {
        log.info("Buscando todos los roles");
        return rolRepo.findAll();
    }

    @Override
    public Rol getRol(Long id) {
        log.info("Buscando el rol de id {}", id);
        return rolRepo.findById(id).orElse(null);
    }

    @Override
    public void saveRol(Rol rol) {
        log.info("Guardando el rol {} en la base de datos", rol.getNombre());
        rolRepo.save(rol);
    }

    @Override
    public void deleteRol(Long id) {
        log.info("Borrando el rol de id {}", id);
        rolRepo.deleteById(id);
    }

    @Override
    public void editRol(Rol rol) {
        log.info("Editando el rol {}", rol);
        rolRepo.save(rol);
    }

    
    
     @Override
    public void addRolToUser(String usuario, String nombreRol) {
            log.info("Añadiendo el rol {} al usuario {} ", nombreRol, usuario);
            Usuario user = usuarioRepository.findByUsuario(usuario);
            Rol rol = rolRepo.findByNombre(nombreRol);
            user.getRoles().add(rol);
    }
    
    
    
    
    
    
    
    
    
}
