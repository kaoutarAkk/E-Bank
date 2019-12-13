package com.bank.demo.Controller;

import com.bank.demo.Model.Compte;
import com.bank.demo.Services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("compte")
public class CompteController {
    @Autowired
    CompteService compteService;

    @RequestMapping("getAllAccounts")
    public List<Compte> getAllComptes(@RequestParam("uid") Long uid){
        return compteService.getAllComptesOfUser(uid);
    }
}
