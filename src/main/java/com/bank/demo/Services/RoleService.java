package com.bank.demo.Services;

import com.bank.demo.Model.Login;
import com.bank.demo.Model.Role;
import com.bank.demo.Repository.LoginRepository;
import com.bank.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    LoginRepository loginRepository;
    public Role saveRole(Role r){return roleRepository.save(r);}
    public List<Role> findAllRole(){return roleRepository.findAll();}
}
