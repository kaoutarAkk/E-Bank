package com.bank.demo.Services;


import com.bank.demo.Model.Login;
import com.bank.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /*public Login findbyEmailAndPassword(String email, String password){
        return loginRepository.findByEmailAndAndPassword(email,password);
    }*/

    public Login findbyEmail(String email){
        return loginRepository.getByEmail(email);
    }

    public boolean existsEmail(String email){

        return loginRepository.existsByEmail(email);

    }

    public List<Login> findAll(){
        return loginRepository.findAll();
    }

    public boolean passCheck(String email,String password){

        Login l = loginRepository.getByEmail(email);
        String pass = l.getPassword();
        return bCryptPasswordEncoder.matches(password,pass);

    }
}
