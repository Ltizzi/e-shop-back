
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Compra;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;


public interface ICompraService {

        public List<Compra> getCompras();
        
        public void saveCompra (Compra compra);
        
        public void deleteCompra (Long id);
        
        public void editCompra (Compra compra);
        
        public Compra getCompra(Long id);
        
        public List<Compra> getByUser(Usuario user);
    
}
