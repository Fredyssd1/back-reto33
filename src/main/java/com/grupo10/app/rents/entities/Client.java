
package com.grupo10.app.rents.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")    
    private Integer idClient;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Integer age;
    
    //@OneToMany(cascade={CascadeType.PERSIST},mappedBy="messa<ge")
    //@JsonIgnoreProperties("message")
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties({"quadbike","client"})    
    private List<Message> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("reservation")
    private List<Reservation> reservations;  
    
    
    
}
