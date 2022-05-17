
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long>{
    
}
