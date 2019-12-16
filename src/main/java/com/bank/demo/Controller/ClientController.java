package com.bank.demo.Controller;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Login;
import com.bank.demo.Services.ClientService;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    LoginService loginService;


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

    }
