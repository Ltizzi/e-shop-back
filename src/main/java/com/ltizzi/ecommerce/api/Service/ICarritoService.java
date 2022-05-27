
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;


public interface ICarritoService {
    
    
    public List<Carrito> getCarritos();
    
    public Carrito buscarCarrito (Long id);
    
    public void saveCarrito(Carrito cart);
    
    public void deleteCarrito(Long id);
    
    public void editarCarrito(Carrito cart);
    
    public List<Carrito> buscarByUser(Usuario user);
    
}
