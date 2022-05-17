
package com.ltizzi.ecommerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Ingreso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ingreso_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto_id;
    
    private int cantidad;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(name = "stock_id")
//    private Stock stock_id;
    
    

    
}
