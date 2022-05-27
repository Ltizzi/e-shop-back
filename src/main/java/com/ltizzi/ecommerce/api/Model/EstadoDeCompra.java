
package com.ltizzi.ecommerce.api.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class EstadoDeCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estado_id;
    
    private String nombre;


    
    
    
}
