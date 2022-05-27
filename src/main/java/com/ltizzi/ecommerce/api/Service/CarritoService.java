
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Carrito;
import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService{
    
    @Autowired
    private CarritoRepository cartRepository;

    @Override
    public List<Carrito> getCarritos() {
        return cartRepository.findAll();
    }
    
    
    @Override
    public Carrito buscarCarrito(Long id) {
        
        Carrito cart = cartRepository.findById(id).orElse(null);
        return cart;
    }

    @Override
    public List<Carrito> buscarByUser(Usuario user) {
        return cartRepository.findByUser(user);
    }
    
    

    @Override
    public void saveCarrito(Carrito cart) {
        
        cartRepository.save(cart);
    }

    @Override
    public void deleteCarrito(Long id) {
        
        cartRepository.deleteById(id);
    }

    @Override
    public void editarCarrito(Carrito cart) {
        cartRepository.save(cart);
    }
    
    
    
}
