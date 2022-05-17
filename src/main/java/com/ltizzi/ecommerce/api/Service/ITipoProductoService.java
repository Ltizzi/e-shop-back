
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.TipoProducto;
import java.util.List;


public interface ITipoProductoService {
    
    public List<TipoProducto> getTipoProductos();
    
    public void saveTipoProd (TipoProducto tipoProd);
    
    public void deleteTipoProd (Long id);
    
    public void editTipoProd (TipoProducto tipoProd);
    
    public TipoProducto getTipoProd (Long id);
    
}
