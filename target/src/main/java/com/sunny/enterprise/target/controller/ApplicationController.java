package com.sunny.enterprise.target.controller;

import com.sunny.enterprise.core.product.exception.UnsupportedProduct;
import com.sunny.enterprise.target.repo.RoleRepository;
import com.sunny.enterprise.target.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    ApplicationController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/users")
    public List getUsers() {
        return userRepository.getUsers();
    }

    @GetMapping("/roles")
    public List getRoles() {
        return roleRepository.getRoles();
    }

    @GetMapping("/throw")
    public List throwOut() {
        throw  new UnsupportedProduct();
    }
}
