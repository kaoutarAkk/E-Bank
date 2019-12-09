package com.bank.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Collection<Role> roles;
    @OneToOne(mappedBy = "login")
    private Utilisateur utilisateur;

    public Login(String email, String password, Utilisateur utilisateur) {
        this.email = email;
        this.password = password;
        this.utilisateur = utilisateur;
    }

    public Login() {
    }
}
