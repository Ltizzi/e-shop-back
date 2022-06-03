
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.EstadoDeCompra;
import com.ltizzi.ecommerce.api.Service.IEstadoDeCompraService;
import java.util.List;
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
@CrossOrigin
public class EstadoDeCompraController {
    
    @Autowired
    private IEstadoDeCompraService edcServ;
    
    @GetMapping("/edc/get")
    @ResponseBody
    public List<EstadoDeCompra> getEdc(){
        System.out.println("Recuperando todos los Estados");
        return edcServ.getEstados();
    }
    
    @GetMapping("edc/buscar")
    @ResponseBody
    public EstadoDeCompra buscarEdc(@RequestParam Long id) {
        System.out.println("Buscando el Estado de Compra de id n°: " + id);
        return edcServ.buscarEstado(id);
    }
    
    @PostMapping("/edc/new")
    public void crearEdc(@RequestBody EstadoDeCompra edc) {
        System.out.println("Creando el nuevo Estado De Compra: " + edc.getNombre());
        edcServ.crearEstado(edc);
    }
    
    @DeleteMapping("/edc/delete")
    public void borrarEdc(@RequestBody Long id) {
        EstadoDeCompra edc = edcServ.buscarEstado(id);
        System.out.println("Eliminando el Estado de Compra de nombre: " + edc.getNombre());
        edcServ.borrarEstado(id);
    }
    
    @PatchMapping("/edc/edit")
    public void editarEdc(@RequestBody EstadoDeCompra edc, @RequestParam Long id) {
        EstadoDeCompra edc_old = edcServ.buscarEstado(id);
        System.out.println("Editando el Estado de Compra de nombre: " + edc_old.getNombre());
        edc.setEstado_id(id);
        edcServ.editarEstado(edc);
        System.out.println("El nuevo nombre de " + edc_old.getNombre() + " es: " + edc.getNombre());
    }
    
}
