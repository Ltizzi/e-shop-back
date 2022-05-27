
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.EstadoDeCompra;
import java.util.List;


public interface IEstadoDeCompraService {
    
    public List<EstadoDeCompra> getEstados();
    
    public EstadoDeCompra buscarEstado(Long id);
    
    public void crearEstado(EstadoDeCompra edc);
    
    public void borrarEstado(Long id);
    
    public void editarEstado(EstadoDeCompra edc);
}
