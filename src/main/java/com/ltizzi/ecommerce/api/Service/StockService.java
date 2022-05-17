
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Stock;
import com.ltizzi.ecommerce.api.Repository.StockRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {
    
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getStock() {
        
        List<Stock> stock = stockRepository.findAll();
        return stock;
    }

    @Override
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void editStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public Stock getStock(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        return stock;
    }
    
    
    
}
