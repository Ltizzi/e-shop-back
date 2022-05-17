
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Ingreso;
import com.ltizzi.ecommerce.api.Model.Producto;
import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Service.IIngresosService;
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
public class IngresoController {
    
        @Autowired
        private IStockService stockServ;
        
        @Autowired
        private IIngresosService ingServ;
        
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        
        @GetMapping("/ingreso/ver")
        @ResponseBody
        public List<Ingreso> verIngresos() {
            return ingServ.getIngresos();
        }

        @GetMapping("/ingreso/buscar")
        @ResponseBody
        public Ingreso buscarIngreso(@RequestParam Long id) {
            return ingServ.getIngreso(id);
        }

        @PostMapping("/ingreso/new")
        public void agregarIngreso(@RequestBody Ingreso ing) {

            Producto prod = ing.getProducto_id();
            Long id = prod.getProducto_id();
            int cant = ing.getCantidad();
            Date fecha = new Date();

            List<Stock> stocks = stockServ.getStock();



            for( Stock stock: stocks) {
                Producto prod2 = stock.getProducto_id();
                Long id_2 = prod2.getProducto_id();
                if (Objects.equals(id, id_2)) {
                    int cant_total = stock.getCantidad();
                    stock.setCantidad( cant_total + cant);
                    stockServ.editStock(stock);
                }

            }

            ing.setFecha(fecha);
            ingServ.saveIngreso(ing);

        }

        @DeleteMapping("/ingreso/delete")
        public void borrarIngreso(@RequestParam Long id) {

            Ingreso ing = ingServ.getIngreso(id);
            int cant = ing.getCantidad();
            Producto prod = ing.getProducto_id();
            Long id2 = prod.getProducto_id();

            List <Stock> stocks = stockServ.getStock();

            for (Stock stock: stocks) {

                Long id3 = (stock.getProducto_id()).getProducto_id();

                if ( Objects.equals(id2, id3) ) { 
                    int cant_total = stock.getCantidad();
                    stock.setCantidad(cant_total - cant);
                    stockServ.saveStock(stock);
                }


            }

            ingServ.deleteIngreso(id);

        }


        @PatchMapping("/ingreso/edit")
        public void editarIngreso(@RequestBody Ingreso ing, @RequestParam Long id) {

            Producto prod = ing.getProducto_id();
            Long prod_id = prod.getProducto_id();
            int cant = ing.getCantidad();

            Ingreso old_ing = ingServ.getIngreso(id);
            int old_cant = old_ing.getCantidad();

            List<Stock> stocks = stockServ.getStock();

            if (old_cant > cant) {

                for (Stock stock: stocks) {
                    Producto prod2 = stock.getProducto_id();
                    Long id2 = prod2.getProducto_id();
                    if (Objects.equals(prod_id, id2)) {
                        int cant_total = stock.getCantidad();
                        stock.setCantidad(cant_total - ( old_cant - cant));
                        stockServ.saveStock(stock);
                    }
                }

            }
            else if ( old_cant < cant ) {

                for (Stock stock: stocks) {
                    Producto prod2= stock.getProducto_id();
                    Long id2 = prod2.getProducto_id();
                    if (Objects.equals(prod_id, id2)) {
                        int cant_total = stock.getCantidad();
                        stock.setCantidad(cant_total + (cant - old_cant));
                        stockServ.saveStock(stock);
                    }
                }
            }
            ing.setIngreso_id(id);
            ingServ.editarIngreso(ing);
        }

    
}
