package com.bank.demo.Controller;

import com.bank.demo.Model.AgentBanque;
import com.bank.demo.Model.Client;
import com.bank.demo.Model.Login;
import com.bank.demo.Services.AgentBanqueService;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("AgentBanques")
public class AgentBanqueController {
    @Autowired
    AgentBanqueService agentBanqueService;

    @Autowired
    LoginService loginService;

    /*@RequestMapping("/isAgent")
    public boolean existsUsername(@RequestParam(name = "email") String email){

        return loginService.existsEmail(email);

    }*/

    @GetMapping("/bylogin")
    public AgentBanque getbyLoginEmail(@RequestParam("email") String email){
        Login l =loginService.findbyEmail(email);
        return agentBanqueService.getByLogin(l) ;
    }
}
