
package com.grupo10.app.rents.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name="tb_message")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")    
    private Integer idMessage;
    @Column
    private String messageText;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quadbike_id")
    @JsonIgnoreProperties({"reservations","messages"})
    private Quadbike quadbike;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
     
    
}
