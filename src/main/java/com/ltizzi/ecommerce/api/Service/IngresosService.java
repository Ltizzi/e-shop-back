
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Ingreso;
import com.ltizzi.ecommerce.api.Model.Producto;
import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Repository.IngresosRepository;
import com.ltizzi.ecommerce.api.Repository.StockRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresosService implements IIngresosService{
    
    @Autowired
    private IngresosRepository inRepository;
    
    @Autowired
    private StockRepository stockRepo;

    @Override
    public List<Ingreso> getIngresos() {
        
        List<Ingreso> listaIngresos = inRepository.findAll();
        return listaIngresos;
        
    }

    @Override
    public void saveIngreso(Ingreso in) {
              
        
        inRepository.save(in);
    }

    @Override
    public void deleteIngreso(Long id) {
        inRepository.deleteById(id);
    }

    @Override
    public Ingreso getIngreso(Long id) {
       Ingreso in =  inRepository.findById(id).orElse(null);
       return in;
    }

    @Override
    public void editarIngreso(Ingreso in) {
        inRepository.save(in);
    }
    
    
    
}
