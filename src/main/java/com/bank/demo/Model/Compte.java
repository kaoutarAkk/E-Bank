package com.bank.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numCompte;
    private double solde;
    private String typeCompte;
    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    private List<Transaction> transactions;
    @ManyToOne
    private Client client;
}
