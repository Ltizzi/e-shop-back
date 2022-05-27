
package com.ltizzi.ecommerce.api.Service;


import com.ltizzi.ecommerce.api.Model.ShopOrder;
import java.util.List;


public interface IShopOrderService {
    
    public  List <ShopOrder> getShopOrders();
    
    public ShopOrder buscarShopOrder(Long id);
    
    public void crearShopOrder(ShopOrder order);
    
    public void borrarShopOrder(Long id);
    
    public void editarShopOrder(ShopOrder order);
    
    public List<ShopOrder> buscarByUserId(Long id);
}
