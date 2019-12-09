package com.bank.demo.Controller;

import com.bank.demo.Services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("compte")
public class CompteController {
    @Autowired
    CompteService compteService;
}
