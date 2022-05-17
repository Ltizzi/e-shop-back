
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Producto;
import com.ltizzi.ecommerce.api.Repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private ProductoRepository prodRepository;

    @Override
    public List<Producto> getProductos() {
        
        List<Producto> listaProductos = prodRepository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto prod) {
        
        prodRepository.save(prod);

    }

    @Override
    public void deleteProducto(Long id) {

        prodRepository.deleteById(id);
        
    }

    @Override
    public Producto getProducto(Long id) {

        Producto prod = prodRepository.findById(id).orElse(null);
        return prod;
        
    }

    @Override
    public void editarProducto(Producto prod) {
        
        prodRepository.save(prod);
        
    }
    
    
   
}
