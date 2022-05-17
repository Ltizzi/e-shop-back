
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProductos();
    
    public void saveProducto (Producto prod);
    
    public void deleteProducto (Long id);
    
    public Producto getProducto (Long id);
    
    public void editarProducto (Producto prod);
    
}
