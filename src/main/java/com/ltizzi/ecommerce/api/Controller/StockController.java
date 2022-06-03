
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Service.IStockService;
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
public class StockController {
    
        
    @Autowired
    private IStockService stockServ;
    
    
     @GetMapping("/stock/ver")
    @ResponseBody
    public List<Stock> getStock() {
        
        return stockServ.getStock();
    
    }
    
    @PostMapping("/stock/new")
    public void agregarStock(@RequestBody Stock stock) {
        stockServ.saveStock(stock);
    }
    
    @DeleteMapping("/stock/delete")
    public void borrarStock(@RequestParam Long id) {
        
        stockServ.deleteStock(id);
    
    }
    
    @PatchMapping("/stock/edit")
    public void editStock(@RequestBody Stock stock, @RequestParam Long id) {
        stock.setStock_id(id);
        stockServ.editStock(stock);
    }
    
    
    @GetMapping("/stock/buscar")
    @ResponseBody
    public Stock buscarStock (@RequestParam Long id) {
        return stockServ.getStock(id);
    }
    
}
