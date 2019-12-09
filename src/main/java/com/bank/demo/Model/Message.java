package com.bank.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String objet;
    private String contenu;
    private String etat;
    @OneToOne(mappedBy = "message",fetch=FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Client client;
    @OneToOne(mappedBy = "message",fetch=FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Transaction transaction;

}
