
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Ingreso;
import java.util.List;


public interface IIngresosService {
    
    public List<Ingreso> getIngresos ();
    
    public void saveIngreso (Ingreso in);
    
    public void deleteIngreso (Long id);
    
    public Ingreso getIngreso (Long id);
    
    public void editarIngreso (Ingreso in);
    
}
