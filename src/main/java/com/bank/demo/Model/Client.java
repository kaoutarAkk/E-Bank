package com.bank.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long phone_number;
    private Date dateNaissance;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;
    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;
    @OneToOne
    private Message message;

}
