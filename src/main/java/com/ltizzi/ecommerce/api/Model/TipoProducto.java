
package com.ltizzi.ecommerce.api.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class TipoProducto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long tipo_prod_id;
    private String nombre;
    

    
}
