
package com.grupo10.app.rents.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_reservation")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")    
    private Integer idReservation;
    @Column
    private Date startDate;
    @Column
    private Date devolutionDate;    
    @Column
    private String status;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quadbike_id")
    @JsonIgnoreProperties({"reservations"})
    private Quadbike quadbike;  
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations","clients"}) 
    private Client client;
    
    @Column
    private String score;  
    
    
}
