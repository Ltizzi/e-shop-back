
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.EstadoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDeCompraRepository extends JpaRepository<EstadoDeCompra, Long> {
    
}
