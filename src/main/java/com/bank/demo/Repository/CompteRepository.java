package com.bank.demo.Repository;

import com.bank.demo.Model.Client;
import com.bank.demo.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
    List<Compte> getAllByClient(Client client);
    Compte getByNumCompte(Long numCompte);

    @Query("SELECT c FROM Compte c WHERE client_id = ?1")
    Compte findComptesByClient(Long client_id);
}
