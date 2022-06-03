
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Producto;
import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Service.IProductoService;
import com.ltizzi.ecommerce.api.Service.IStockService;
import java.util.List;
import java.util.Objects;
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
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ;
      
    @Autowired
    private IStockService stockServ;
    
      @GetMapping ("/producto/ver")
    @ResponseBody
    public List<Producto> getProductos() {
        return prodServ.getProductos();
    }
    
    @PostMapping("/producto/new")
    public void agregarProducto (@RequestBody Producto prod) {
            
            prodServ.saveProducto(prod);
            
            List<Producto> productos = prodServ.getProductos();
            Producto new_prod = new Producto();
            
            for (Producto produ: productos) {
                if (Objects.equals(prod.getNombre(), produ.getNombre())) {
                    new_prod = produ;
                }
            }
            
            Stock stock = new Stock();
            stock.setProducto_id(new_prod);
            stock.setCantidad(0);
            stockServ.saveStock(stock);
            
    
    }
    
    @DeleteMapping("/producto/delete")
    public void borrarProducto (@RequestParam Long id) {
            
            prodServ.deleteProducto(id);
    
    }
    
    @GetMapping("/producto/buscar")
    @ResponseBody    
    public Producto buscarProducto(@RequestParam Long id) {
        
        return prodServ.getProducto(id);
    }
    
    @PatchMapping("/producto/edit")
    public void editarProducto(@RequestBody Producto prod, @RequestParam Long id) {
        prod.setProducto_id(id);
        prodServ.editarProducto(prod);
    
    }
    
}
