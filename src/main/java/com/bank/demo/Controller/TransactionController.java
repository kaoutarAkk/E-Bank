package com.bank.demo.Controller;

import com.bank.demo.Model.Compte;
import com.bank.demo.Model.Transaction;
import com.bank.demo.Repository.CompteRepository;
import com.bank.demo.Services.CompteService;
import com.bank.demo.Services.TransactionService;
//import com.bank.demo.wsdl.Recharge;
import com.bank.demo.config.MessagingConfiguration;
import com.bank.demo.wsdl.RechargeRequest;
import com.bank.demo.wsdl.RechargeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    CompteService compteService;

    @RequestMapping("ajouterVersement")
    public boolean newVersement(@RequestParam("compte")Long compte,@RequestParam("benif")Long numC,@RequestParam("montant")double montant){
        return transactionService.addVersement(compte,numC,montant);
    }

//    @RequestMapping("ajouterRecharge")
//    public boolean newRecharge(@RequestParam("compte")Long compte,@RequestParam("benif")Long numT,@RequestParam("montant")double montant,@RequestParam("op")String operateur){
//
////            RechargeRequest rechargeRequest = new RechargeRequest();
////            rechargeRequest.setNumero(String.valueOf(numT));
////            rechargeRequest.setMontant(montant);
////            RechargeResponse rechargeResponse = newRechargeResp(rechargeRequest);
////            return transactionService.addRecharge(compte,numT,montant,operateur,rechargeResponse);
//
//    }

    @PostMapping("ajouterRechargeWS")
    public RechargeResponse newRechargeResp(@RequestBody RechargeRequest recharge,@RequestParam("compte")Long compte){
        Compte c = compteService.getCompteByNum(compte);
        JmsTemplate jms = new MessagingConfiguration().jmsTemplate();
        RechargeResponse rs=new RechargeResponse();
        if(c.getSolde() > recharge.getMontant()){
            rs=transactionService.getRechargeResponse(recharge);
            if(rs.isReturn()){
                 transactionService.addRecharge(compte,Long.parseLong(recharge.getNumero()),recharge.getMontant());
            }
            String s = (String) jms.receiveAndConvert(MessagingConfiguration.MESSAGE_QUEUE);
            System.out.println(s);
        }
       return rs;
    }


    @GetMapping(value = "getaccountTransactions")
    public List<Transaction> getAllAccountTransactions(@RequestParam("compte_id") Long compte_id){
        return transactionService.getTransactionsbyCompte(compte_id);

    }
}
