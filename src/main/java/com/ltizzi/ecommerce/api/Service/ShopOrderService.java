
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.ShopOrder;
import com.ltizzi.ecommerce.api.Repository.ShopOrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopOrderService implements IShopOrderService {
    
    
    @Autowired
    private ShopOrderRepository orderRepo;
    

    @Override
    public List<ShopOrder> getShopOrders() {
        return orderRepo.findAll();
    }

    @Override
    public ShopOrder buscarShopOrder(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public void crearShopOrder(ShopOrder order) {
        orderRepo.save(order);
    }

    @Override
    public void borrarShopOrder(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public void editarShopOrder(ShopOrder order) {
        orderRepo.save(order);
    }

    @Override
    public List<ShopOrder> buscarByUserId(Long id) {
        List <ShopOrder> orders = orderRepo.findAll();
        List <ShopOrder> filtradas = new ArrayList<>();
        
        for (ShopOrder order: orders) {
            if (Objects.equals(order.getUser().getUser_id(), id)) {
                filtradas.add(order);
            }
        }
        return filtradas;
    }
    
    
    
    
    
}
