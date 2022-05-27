
package com.ltizzi.ecommerce.api.Repository;

import com.ltizzi.ecommerce.api.Model.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long>{
    
//    ShopOrder findByUserId(Long id);
    
}
