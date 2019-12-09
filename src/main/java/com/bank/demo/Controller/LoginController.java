package com.bank.demo.Controller;

import com.bank.demo.Model.Role;
import com.bank.demo.Repository.RoleRepository;
import com.bank.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    LoginService loginService;
    RoleRepository roleRepository;

}
