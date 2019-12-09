package com.bank.demo.Controller;

import com.bank.demo.Services.AgentBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("AgentBanque")
public class AgentBanqueController {
    @Autowired
    AgentBanqueService agentBanqueService;
}
