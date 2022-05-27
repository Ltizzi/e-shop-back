
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.EstadoDeCompra;
import com.ltizzi.ecommerce.api.Model.ShopOrder;
import com.ltizzi.ecommerce.api.Service.ICarritoService;
import com.ltizzi.ecommerce.api.Service.IEstadoDeCompraService;
import com.ltizzi.ecommerce.api.Service.IShopOrderService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopOrderController {
    
    @Autowired
    private IShopOrderService orderServ;
    
    @Autowired
    private ICarritoService cartServ;
    
    @Autowired
    private IEstadoDeCompraService edcServ;
    
    
    @GetMapping("/order/ver")
    @ResponseBody
    public List<ShopOrder> verOrders() {
        return orderServ.getShopOrders();
    }
    
    @GetMapping("/order/buscar")
    @ResponseBody
    public ShopOrder buscarOrder(@RequestParam Long id) {
        return orderServ.buscarShopOrder(id);
    }
    
    @GetMapping("/order/findByUser")
    @ResponseBody
    public List<ShopOrder> buscarPorUsuario(@RequestParam Long id) {
        return orderServ.buscarByUserId(id);
    }
    
    @PostMapping("/order/new")
    public void crearOrder(@RequestBody Carrito cartie) {
        Long cart_id = cartie.getCart_id();
        Carrito cart = cartServ.buscarCarrito(cart_id);
        EstadoDeCompra edc = edcServ.buscarEstado(1L);
        
        System.out.println("Creando la orden de compra para el carrito id: " + cart.getCart_id());
        ShopOrder order = new ShopOrder();
        
        order.setProducto(cart.getProducto());
        order.setCantidad(cart.getCantidad());
        order.setTotal_gastado(cart.getTotal_gastado());
        order.setUser(cart.getUser());
        order.setEstado(edc);
        order.setFecha(LocalDate.now());
        System.out.println(order);
        orderServ.crearShopOrder(order);
        cartServ.deleteCarrito(cart_id);
        
    }
    
    @DeleteMapping("/order/delete")
    public void borrarOrder(@RequestParam Long id) {
        orderServ.borrarShopOrder(id);
    }
    
    @PatchMapping("/order/edit")
    public void editarOrder(@RequestBody ShopOrder order, @RequestParam Long id) {
        
        order.setOrder_id(id);
      
        orderServ.editarShopOrder(order);
    }
    
}
