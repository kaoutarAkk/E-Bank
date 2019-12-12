package com.bank.demo.Repository;

import com.bank.demo.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface LoginRepository extends JpaRepository<Login,Long> {
    public Login findByEmailAndAndPassword(String email,String password);
}
