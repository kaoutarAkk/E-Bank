package com.bank.demo.Services;

import com.bank.demo.Model.Compte;
import com.bank.demo.Repository.ClientRepository;
import com.bank.demo.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompteService {
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    ClientRepository clientRepository;

    public List<Compte> getAllComptesOfUser(Long uid){
        return compteRepository.getAllByClient(clientRepository.getById(uid));
    }

    public Compte getCompteByNum(Long num){
        return compteRepository.getByNumCompte(num);
    }


    public Compte getCilentCompte(Long client_id) {
        Compte compte = compteRepository.findComptesByClient(client_id);

        return compte;
    }


    public void deleteCompteById(Long id){
        compteRepository.deleteById(id);
    }

    public void saveCompte(Compte compte) {
        compteRepository.save(compte);
    }

}
