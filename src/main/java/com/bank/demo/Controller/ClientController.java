package com.bank.demo.Controller;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Login;
import com.bank.demo.Services.ClientService;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.bank.demo.Model.Compte;
import com.bank.demo.Services.CompteService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    LoginService loginService;

    @Autowired
    CompteService compteService;



    @RequestMapping("/byloginId")
    public Client getbyLogin_Id(@RequestParam("id") String id){
        Long id1 =Long.valueOf(id) ;
        return clientService.getByLoginId(id1);
    }
    @GetMapping("/bylogin")
    public Client getbyLoginEmail(@RequestParam("email") String email){
        Login l =loginService.findbyEmail(email);
       return clientService.getByLogin(l) ;
    }

    @RequestMapping("/allClients")
    public List<Client> getAllCLients(){
        return clientService.getAllClients();
    }

    @PostMapping("/saveClient")
    public void saveClient(@RequestBody Client client){
        Login login=client.getLogin();
        BCryptPasswordEncoder b=new BCryptPasswordEncoder();
        login.setPassword(b.encode(login.getPassword()));
        loginService.saveLogin(login);
        Compte compte=client.getCompte();
        compte.setClient(client);
        client.setCompte(null);
        clientService.saveClient(client);
        compteService.saveCompte(compte);
    }

    @DeleteMapping("/deleteClientById")
    public void deleteClientById(@RequestParam(name="id")Long id){
        Client c=clientService.getById(id);
        Compte compte=c.getCompte();
        Login login=c.getLogin();
        loginService.deleteLoginById(login.getId());
        clientService.deleteClientById(c.getId());
        compteService.deleteCompteById(compte.getId());
    }
    }
