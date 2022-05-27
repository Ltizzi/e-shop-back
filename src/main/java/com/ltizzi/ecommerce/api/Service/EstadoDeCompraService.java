
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.EstadoDeCompra;
import com.ltizzi.ecommerce.api.Repository.EstadoDeCompraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoDeCompraService implements IEstadoDeCompraService{
    
    @Autowired
    private EstadoDeCompraRepository edcRepo;

    @Override
    public List<EstadoDeCompra> getEstados() {
        return edcRepo.findAll();
    }

    @Override
    public EstadoDeCompra buscarEstado(Long id) {
        return edcRepo.findById(id).orElse(null);
    }

    @Override
    public void crearEstado(EstadoDeCompra edc) {
        edcRepo.save(edc);
    }

    @Override
    public void borrarEstado(Long id) {
        edcRepo.deleteById(id);
    }

    @Override
    public void editarEstado(EstadoDeCompra edc) {
        edcRepo.save(edc);
    }
    
    
}
