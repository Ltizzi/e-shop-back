
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    
    Rol findByNombre(String name);
    
}
