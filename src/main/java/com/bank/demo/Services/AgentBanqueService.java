package com.bank.demo.Services;

import com.bank.demo.Model.AgentBanque;
import com.bank.demo.Model.Login;
import com.bank.demo.Repository.AgentBanqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentBanqueService {
    @Autowired
    AgentBanqueRepo agentBanqueRepo;

    public AgentBanque getByLogin(Login login){
        return agentBanqueRepo.getByLogin(login);
    }

    public Boolean existsByLoginId(Long id){
        return agentBanqueRepo.existsByLoginId(id);
    }
}
