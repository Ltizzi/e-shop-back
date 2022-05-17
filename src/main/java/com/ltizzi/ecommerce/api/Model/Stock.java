
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
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long stock_id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto_id; 
    
    
//    @OneToMany(fetch = FetchType.EAGER)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private List<Ingreso> ingreso_id = new ArrayList<> ();
    
    private int cantidad;
    
}
