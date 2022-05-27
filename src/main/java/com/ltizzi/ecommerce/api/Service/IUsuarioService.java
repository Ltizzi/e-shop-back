
package com.ltizzi.ecommerce.api.Service;

import com.ltizzi.ecommerce.api.Model.Rol;
import com.ltizzi.ecommerce.api.Model.Usuario;
import java.util.List;


public interface IUsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public void saveUsuario (Usuario user);
    
    public void deleteUsuario (Long id);
    
    public void editUsuario (Usuario user);
    
    public Usuario getUsuario(Long id);
    
    public Usuario getByUsuario(String usuario);
    
    //
    
    
    
    public void addRolToUser(String usuario, String nombreRol);
    
    public List<Rol> getRoles();
    
    public Rol getRol(Long id);
    
    public void saveRol(Rol rol);
    
    public void deleteRol(Long id);
    
    public void editRol(Rol rol);
    
}
