package com.bank.demo.Services;

import com.bank.demo.Repository.AgentBanqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentBanqueService {
    @Autowired
    AgentBanqueRepo agentBanqueRepo;
}
