package com.bank.demo.Services;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Login;
import com.bank.demo.Repository.ClientRepository;
import com.bank.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    LoginRepository loginRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client getByLoginId(Long id){
        return clientRepository.getByLogin_Id(id);
    }

    public Client getByLogin(Login login ){
        return clientRepository.getByLogin(login);
    }

    public Boolean existByLoginId(Long id){
        return clientRepository.existsByLoginId(id);
    }

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
