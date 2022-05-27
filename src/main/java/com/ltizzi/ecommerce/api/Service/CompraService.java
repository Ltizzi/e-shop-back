
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Compra;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltizzi.ecommerce.api.Repository.CompraRepository;

@Service
public class CompraService implements ICompraService{

        @Autowired
        private CompraRepository compraRepository;

    @Override
    public List<Compra> getCompras() {
        List<Compra> listaCompras = compraRepository.findAll();
        return listaCompras;
    }

    @Override
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void deleteCompra(Long id) {
        compraRepository.deleteById(id);
    }

    @Override
    public void editCompra(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public Compra getCompra(Long id) {
        Compra compra = compraRepository.findById(id).orElse(null);
        return compra;
    }

    @Override
    public List<Compra> getByUser(Usuario user) {
        
        List<Compra> compras = compraRepository.findByUser(user);
        
        return compras;

    }
        
        
    
    
}
