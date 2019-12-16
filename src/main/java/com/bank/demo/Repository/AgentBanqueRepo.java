package com.bank.demo.Repository;

import com.bank.demo.Model.AgentBanque;
import com.bank.demo.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface AgentBanqueRepo extends JpaRepository<AgentBanque,Long> {
    public AgentBanque getByLogin(Login login);
    public Boolean existsByLoginId(Long id);
}
