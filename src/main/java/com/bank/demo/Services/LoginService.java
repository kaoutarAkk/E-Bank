package com.bank.demo.Services;


import com.bank.demo.Model.Login;
import com.bank.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public Login findbyEmailAndPassword(String email, String password){
        return loginRepository.findByEmailAndAndPassword(email,password);
    }

    public List<Login> findAll(){
        return loginRepository.findAll();
    }
}
