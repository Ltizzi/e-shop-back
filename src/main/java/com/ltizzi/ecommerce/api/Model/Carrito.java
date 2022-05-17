
package com.ltizzi.ecommerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cart_id;
    private Double total_gastado;
    private int cantidad;
 
    
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable= true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario user;


    
    
    
    
}

    