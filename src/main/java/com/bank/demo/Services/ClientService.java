package com.bank.demo.Services;

import com.bank.demo.Model.Client;
import com.bank.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

//    public Client saveClient(Client client){
//        return clientRepository.save(client);
//    }
//
//    public List<Client> getAll(){
//        return clientRepository.findAll();
//    }
//    public Optional<Client> findByid(Long id) {
//        Optional<Client> cl;
//        cl=clientRepository.findById(id);
//        return cl;
//    }
}
