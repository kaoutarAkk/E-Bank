package com.bank.demo;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Compte;
import com.bank.demo.Model.Login;
import com.bank.demo.Repository.ClientRepository;
import com.bank.demo.Repository.CompteRepository;
import com.bank.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    LoginRepository lr;
    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);}


    @Override
    public void run(String... args) throws Exception {
    lr.save(new Login((long) 3,"admin@admin.com","admin"));
    }



}
