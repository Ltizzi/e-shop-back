
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Long> {
    
    List<Carrito> findByUser(Usuario user);
    
}
