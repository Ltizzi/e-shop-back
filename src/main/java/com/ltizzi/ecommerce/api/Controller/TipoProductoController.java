
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.TipoProducto;
import com.ltizzi.ecommerce.api.Service.ITipoProductoService;
import java.util.List;
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
public class TipoProductoController {
    
        
    @Autowired
    private ITipoProductoService tipoproServ;
    
    
    @GetMapping ("/tipo/ver")
    @ResponseBody
    public List<TipoProducto> getTipos() {
        return tipoproServ.getTipoProductos();
    }
    
    @PostMapping("/tipo/new")
    public void agregarTipo (@RequestBody TipoProducto tipo) {
        
            tipoproServ.saveTipoProd(tipo);
    
    }
    
    @DeleteMapping("/tipo/delete")
    public void borrarTipo (@RequestParam Long id) {
            
            tipoproServ.deleteTipoProd(id);
    
    }
    
    @GetMapping("/tipo/buscar")
    @ResponseBody    
    public TipoProducto buscarTipo(@RequestParam Long id) {
        
        return tipoproServ.getTipoProd(id);
    }
    
    @PatchMapping("/tipo/edit")
    public void editarTipo(@RequestBody TipoProducto tipo, @RequestParam Long id) {
        tipo.setTipo_prod_id(id);
        tipoproServ.editTipoProd(tipo);
    
    }
    
}
