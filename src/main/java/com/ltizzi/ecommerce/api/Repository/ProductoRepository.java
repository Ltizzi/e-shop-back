
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
  
    
}
