package com.bank.demo.Controller;

import com.bank.demo.Model.Login;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/all")
    public List<Login> getAll( ){

        return loginService.findAll();
    }
    @GetMapping("/ByEmailAndPass")
    public Login getCategoryById(@RequestParam(name="email")String  email,@RequestParam(name="pass")String  password ){

        return loginService.findbyEmailAndPassword(email,password);
    }
}
