
package com.ltizzi.ecommerce.api.Controller;

import com.ltizzi.ecommerce.api.Model.Usuario;
import com.ltizzi.ecommerce.api.Service.IUsuarioService;
import java.util.List;
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
public class UsuarioController {
    
      
    @Autowired
    private IUsuarioService userServ;
    
    @GetMapping("/user/ver")
    @ResponseBody
    public List<Usuario> getUsers() {
        return    userServ.getUsuarios();
    }
    
    @GetMapping("/user/buscar")
    @ResponseBody
    public Usuario buscarUsuario(@RequestParam Long id) {
        return userServ.getUsuario(id);
    }
    
    @PostMapping("/user/new")
    public void crearUsuario(@RequestBody Usuario user) {
        userServ.saveUsuario(user);
    }
    
    @DeleteMapping("/user/delete")
    public void borrarUsuario(@RequestParam Long id) {
        userServ.deleteUsuario(id);
    }
    
    @PatchMapping("/user/edit")
    public void editarUsuario(@RequestBody Usuario user, @RequestParam Long id) {
        user.setUser_id(id);
        userServ.editUsuario(user);
    }
    
    
    
}
