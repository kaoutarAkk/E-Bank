package com.bank.demo.Model;

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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToOne
    private Login login;
    private Long phone_number;
    private String dateNaissance;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;
    @OneToMany(mappedBy = "client")
    private List<Message> messages;

}
