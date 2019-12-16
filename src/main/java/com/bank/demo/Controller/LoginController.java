package com.bank.demo.Controller;

import com.bank.demo.Model.Login;
import com.bank.demo.Services.AgentBanqueService;
import com.bank.demo.Services.ClientService;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("logins")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    ClientService clientService;

    @Autowired
    AgentBanqueService agentBanqueService;

    @GetMapping("/all")
    public List<Login> getAll( ){

        return loginService.findAll();
    }
    /*@GetMapping("/ByEmailAndPass")
    public Login getByEmailAndPass(@RequestParam(name="email")String  email,@RequestParam(name="pass")String  password ){

        return loginService.findbyEmailAndPassword(email,password);
    }*/

    @RequestMapping("/existsEmail")
    public boolean existsUsername(@RequestParam(name = "email") String email){

        return loginService.existsEmail(email);

    }
    @RequestMapping("/isClient")
    public boolean isClient(@RequestParam(name = "id") String id){
        Long i = Long.valueOf(id);
        return clientService.existByLoginId(i);

    }
    @RequestMapping("/isAgent")
    public boolean isAgent(@RequestParam(name = "id") String id){
        Long i = Long.valueOf(id);
        return agentBanqueService.existsByLoginId(i);

    }

    @RequestMapping("/checkPwd")
    public boolean checkpassword(@RequestParam("email") String email,@RequestParam("password") String password){

        return loginService.passCheck(email,password);

    }
    @RequestMapping("/byEmail")
    public Login getByEmail(@RequestParam("email") String email){

        return loginService.findbyEmail(email);

    }



}
