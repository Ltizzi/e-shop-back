
package com.ltizzi.ecommerce.api.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id;
    
    private String usuario;
    private String password;
    
    private String nombre;
    private String apellido;
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name= "cart_id", nullable=true)
//    private List<Carrito> carritos = new ArrayList<>();
    
//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<Compra> compras = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Rol> roles = new ArrayList<>();
}
