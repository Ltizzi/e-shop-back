
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.ShopOrder;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long>{
    
    List<ShopOrder> findByUser(Usuario user);
    
}
