package com.bank.demo.Controller;

import com.bank.demo.Model.Compte;
import com.bank.demo.Services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/compte")
public class CompteController {
    @Autowired
    CompteService compteService;

    @GetMapping(value = "getAllAccounts")
    public List<Compte> getAllComptes(@RequestParam("uid") Long uid){
        return compteService.getAllComptesOfUser(uid);
    }




}
