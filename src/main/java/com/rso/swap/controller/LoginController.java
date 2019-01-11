package com.rso.swap.controller;

import com.rso.swap.model.Employee;
import com.rso.swap.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public String isValidUser(@RequestBody String empcode, @RequestBody String password){
        Employee employee = loginService.validateEmployee(empcode, password);
        return "200";
    }
}
