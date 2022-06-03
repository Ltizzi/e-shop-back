
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.Producto;
import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Service.ICarritoService;
import com.ltizzi.ecommerce.api.Service.IProductoService;
import com.ltizzi.ecommerce.api.Service.IUsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class CarritoController {

    
                @Autowired
                private IProductoService prodServ;
                
                @Autowired
                private ICarritoService cartServ;
                
                @Autowired
                private IUsuarioService userServ;
                
                
               @GetMapping("/cart/ver")
               @ResponseBody
               public List<Carrito> getCarritos() {
                   return cartServ.getCarritos();
               }


               @GetMapping("/cart/buscar")
               @ResponseBody
               public Carrito buscarCarrito(@RequestParam Long id) {
                   return cartServ.buscarCarrito(id);
               }
               
               @GetMapping("cart/buscarBy")
               public List<Carrito> buscarByUser(@RequestParam String usuario){
                   Usuario user = userServ.getByUsuario(usuario);
                   return cartServ.buscarByUser(user);
               }

               @PostMapping("/cart/new")
               public void crearCarrito(@RequestBody Carrito cart) {
                   Long id = (cart.getProducto()).getProducto_id();
                   Producto prod = prodServ.getProducto(id);
                   Double precio = prod.getPrecio();
                   int cant = cart.getCantidad();
                   cart.setTotal_gastado(precio * cant);
                   cartServ.saveCarrito(cart);
               }

               @DeleteMapping("/cart/delete")
               public void borrarCarrito(@RequestParam Long id) {
                   cartServ.deleteCarrito(id);
               }

               @PatchMapping("/cart/edit")
               public void editarCarrito(@RequestBody Carrito cart, @RequestParam Long id) {
                   Long id_finder = cart.getProducto().getProducto_id();
                   Producto prod = prodServ.getProducto(id_finder);
                   Double precio = prod.getPrecio();
                   int cant = cart.getCantidad();
                   cart.setTotal_gastado(precio * cant);
                   cart.setCart_id(id);
                   cartServ.saveCarrito(cart);
               }

    
}
