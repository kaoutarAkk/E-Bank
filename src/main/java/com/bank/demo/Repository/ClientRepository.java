package com.bank.demo.Repository;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client getById(Long id);

    public Client getByLogin_Id(Long id);
    public Client getByLogin(Login login);
    public Boolean existsByLoginId(Long id);



    Client save(Client client);

    void deleteById(Client client);

}
