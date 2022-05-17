
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Long> {
    
}
