
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.Compra;
import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Service.ICompraService;
import com.ltizzi.ecommerce.api.Service.IStockService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
public class CompraController {

    @Autowired
    private ICompraService compraServ;
        
    @Autowired
    private IStockService stockServ;
    
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    
    @GetMapping("/compra/ver")
    @ResponseBody
    public List<Compra> getCompras() {
        return compraServ.getCompras();
    }
    
    @GetMapping("/compra/buscar")
    @ResponseBody
    public Compra buscarCompra(@RequestParam Long id) {
        return compraServ.getCompra(id);
    }
    
    @PostMapping("/compra/new")
    public void crearCompra(@RequestBody Compra comp) {
        List<Carrito> items = comp.getItems();
        List<Stock> stocks = stockServ.getStock();
        Double monto = 0.00;
        Date fecha = new Date();
        
        for (Carrito item: items) {
            Long prod_id = item.getProducto().getProducto_id();
            monto+= (item.getTotal_gastado());
            for (Stock stock: stocks) {
                Long id2 = (stock.getProducto_id()).getProducto_id();
                if (Objects.equals(prod_id, id2)) {
                        int cant_total = stock.getCantidad();
                        stock.setCantidad(cant_total - item.getCantidad());
                        stockServ.saveStock(stock);
                    }
                }
        }
        comp.setMonto(monto);
        comp.setFecha(fecha);
        compraServ.saveCompra(comp);
    }
    
    @DeleteMapping("/compra/delete")
    public void borrarCompra(@RequestParam Long id) {
        
        Compra comp = compraServ.getCompra(id);
        List<Carrito> items = comp.getItems();
        List<Stock> stocks = stockServ.getStock();
        
        for (Carrito item: items) {
            Long prod_id = (item.getProducto()).getProducto_id();
            int cant = item.getCantidad();
            
            for (Stock stock: stocks) {
                Long id2 = (stock.getProducto_id()).getProducto_id();
                if (Objects.equals(prod_id, id2)) {
                    int cant_total = stock.getCantidad();
                    stock.setCantidad(cant_total - cant);
                    stockServ.saveStock(stock);
                }
            }
        
        }
        
        compraServ.deleteCompra(id);
    }
    
    @PatchMapping("/compra/edit")
    public void editarCompra(@RequestBody Compra comp, @RequestParam Long id) {
        
        
        List<Carrito> items = comp.getItems();
        List<Stock> stocks = stockServ.getStock();
        List<Carrito> old_items = (compraServ.getCompra(id)).getItems();
        Double monto = 0.00;
        
        for (Carrito item: items) {
            Long prod_id = (item.getProducto()).getProducto_id();
            int cant = item.getCantidad();
            monto+= item.getTotal_gastado();
            
            for (Carrito old_item: old_items) {
                int old_cant = old_item.getCantidad();
                
                if (cant > old_cant) {
                       for (Stock stock: stocks) {
                             Long id2 = stock.getStock_id();
                             if (Objects.equals(prod_id, id2)) {
                                 int cant_total = stock.getCantidad();
                                 stock.setCantidad(cant_total + (cant - old_cant));
                                 stockServ.saveStock(stock);
                             }
                       }
                }
                
                else if (cant < old_cant) {
                        for (Stock stock: stocks) {
                            Long id2 = stock.getStock_id();
                            if (Objects.equals(prod_id, id2)) {
                                int cant_total = stock.getCantidad();
                                stock.setCantidad(cant_total - (old_cant - cant));
                                stockServ.saveStock(stock);
                            }
                        }
                }
            }         
        }
        comp.setMonto(monto);
        comp.setCompra_id(id);
        compraServ.editCompra(comp);
    }
    

    
}
