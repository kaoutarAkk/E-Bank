package com.bank.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    public Login(Long id,String email,String pass){
        this.id = id ;
        this.email=email;
        BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
        pass =(bcr.encode((CharSequence)pass));
        this.password=pass;
    }
}
