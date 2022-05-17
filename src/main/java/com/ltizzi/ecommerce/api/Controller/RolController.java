
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Rol;
import com.ltizzi.ecommerce.api.Service.IUsuarioService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RolController {

    @Autowired
    private IUsuarioService userServ;
    
    
    @GetMapping("/rol/ver")
    @ResponseBody
    public List<Rol> buscarRoles() {
        return userServ.getRoles();
    }
    
    @GetMapping("/rol/buscar")
    @ResponseBody
    public Rol buscarRol(@RequestParam Long id) {
        return userServ.getRol(id);
    }
    
    
    @PostMapping("/rol/save")
    public void guardarRol(@RequestBody Rol rol) {
        userServ.saveRol(rol);
    }
    
    @DeleteMapping("/rol/delete")
    public void borrarRol(@RequestParam Long id){
        userServ.deleteRol(id);
    }
    
    @PatchMapping("/rol/edit")
    public void editarRol(@RequestBody Rol rol, @RequestParam Long id) {
        rol.setRol_id(id);
        userServ.saveRol(rol);
    }
    
    @PostMapping("rol/addtouser")
    public void addRoltoUser(@RequestBody RoleToUserForm form) {
        userServ.addRolToUser(form.getUsuario(), form.getRol());
    }
    
    
}

@Data
class RoleToUserForm {
    private String usuario;
    private String rol;
}
    

