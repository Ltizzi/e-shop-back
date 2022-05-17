
package com.ltizzi.ecommerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    private Long compra_id;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Carrito> items = new ArrayList<>();

    
    private Double monto;
    

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
   
   
    
}
