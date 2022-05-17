
package com.ltizzi.ecommerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long producto_id;
    private String nombre;
    private String marca;
    private String about;
    private String img_url_1;
    private String img_url_2;
    private String img_url_3;
    private String img_url_4;    
    private Double  precio;
    
    

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="tipo_prod_id", nullable = false)
    private TipoProducto tipo;
    
}
