package com.rso.swap.controller;

import com.rso.swap.model.Employee;
import com.rso.swap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/signup")
    public String registration(Model model, HttpServletResponse response) {
        model.addAttribute("empForm", new Employee());
        response.setHeader("Content-Type","text/html");
        return "signupfail";
    }

    @PostMapping("/signup")
    public String registration(@RequestBody Employee employee) {

        Employee employeeExists = employeeService.getEmployeeByEmpcode((long) employee.getEmpcode());

        if(employeeExists != null) {
            return "welcome";
        }

        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employeeService.addEmployee(employee);
        return "welcome";
    }
}

