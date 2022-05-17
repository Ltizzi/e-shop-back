
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Stock;
import java.util.List;


public interface IStockService {
    
    public List<Stock> getStock ();
    
    public void saveStock (Stock stock);
    
    public void deleteStock (Long id);
    
    public void editStock (Stock stock);
    
    public Stock getStock (Long id);
    
}
