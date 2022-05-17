
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.TipoProducto;
import com.ltizzi.ecommerce.api.Repository.TipoProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService implements ITipoProductoService {
    
        @Autowired
        private TipoProductoRepository tipoProdRepository;

    @Override
    public List<TipoProducto> getTipoProductos() {
        List<TipoProducto> tipos = tipoProdRepository.findAll();
        return tipos;
    }

    @Override
    public void saveTipoProd(TipoProducto tipoProd) {
        tipoProdRepository.save(tipoProd);
    }

    @Override
    public void deleteTipoProd(Long id) {
        tipoProdRepository.deleteById(id);
    }

    @Override
    public void editTipoProd(TipoProducto tipoProd) {
        tipoProdRepository.save(tipoProd);
    }

    @Override
    public TipoProducto getTipoProd(Long id) {
        TipoProducto tipoP = tipoProdRepository.findById(id).orElse(null);
        return tipoP;
    }
        
        
        
    
}
