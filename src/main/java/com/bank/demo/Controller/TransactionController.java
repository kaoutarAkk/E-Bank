package com.bank.demo.Controller;

import com.bank.demo.Model.Transaction;
import com.bank.demo.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping("ajouterVersement")
    public boolean newVersement(@RequestParam("compte")Long compte,@RequestParam("benif")Long numC,@RequestParam("montant")double montant){
        return transactionService.addVersement(compte,numC,montant);
    }

    @RequestMapping("ajouterRecharge")
    public boolean newRecharge(@RequestParam("compte")Long compte,@RequestParam("benif")Long numT,@RequestParam("montant")double montant,@RequestParam("op")String operateur){
        return transactionService.addRecharge(compte,numT,montant,operateur);
    }
}
