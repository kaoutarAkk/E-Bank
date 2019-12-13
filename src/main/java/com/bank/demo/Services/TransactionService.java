package com.bank.demo.Services;

import com.bank.demo.Model.Compte;
import com.bank.demo.Model.Transaction;
import com.bank.demo.Repository.ClientRepository;
import com.bank.demo.Repository.CompteRepository;
import com.bank.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;

    public boolean addVersement(Long compte, Long numC, double montant) {
        boolean result=false;
        Compte c = compteRepository.getByNumCompte(numC);
        if( c == null)
            result = false;
        else{
            Compte c2 = compteRepository.getByNumCompte(compte);
            if(c2.getSolde() < montant)
                result = false;
            else{
                c2.setSolde(c2.getSolde() - montant);
                c.setSolde(c.getSolde() + montant);
                compteRepository.save(c);
                compteRepository.save(c2);

                Transaction transaction = new Transaction();
                transaction.setDateTransaction(Calendar.getInstance().getTime().toString());
                transaction.setType("Virement par le compte "+compte.toString());
                transaction.setCompte(c);
                transaction.setMontant(montant);
                transactionRepository.save(transaction);

                Transaction transaction1 = new Transaction();
                transaction1.setDateTransaction(Calendar.getInstance().getTime().toString());
                transaction1.setType("Versement pour le compte "+numC.toString());
                transaction1.setCompte(c2);
                transaction1.setMontant(montant);
                transactionRepository.save(transaction1);

                result = true;
            }
        }
        return result;
    }

    public boolean addRecharge(Long compte, Long numT, double montant, String operateur) {
        Compte compte1 = compteRepository.getByNumCompte(compte);
        if(compte1.getSolde() < montant)
            return false;
        else{
            compte1.setSolde(compte1.getSolde() - montant);
            compteRepository.save(compte1);

            Transaction transaction = new Transaction();
            transaction.setDateTransaction(Calendar.getInstance().getTime().toString());
            transaction.setType("Recharge telephonique ("+operateur+") de "+numT.toString());
            transaction.setCompte(compte1);
            transaction.setMontant(montant);
            transactionRepository.save(transaction);

            return true;
        }
    }
}
