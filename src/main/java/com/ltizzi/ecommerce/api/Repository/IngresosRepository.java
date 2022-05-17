
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresosRepository extends JpaRepository<Ingreso, Long>{
    
}
