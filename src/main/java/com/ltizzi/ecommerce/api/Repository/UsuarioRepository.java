
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Rol;
import com.ltizzi.ecommerce.api.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    
    Usuario findByUsuario(String usuario);
          
    
}
