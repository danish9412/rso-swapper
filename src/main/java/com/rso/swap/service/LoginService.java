package com.rso.swap.service;

import com.rso.swap.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmployeeService employeeService;

    public Employee validateEmployee(String empcode, String password){

        if(empcode.isEmpty() || password.isEmpty()) {
            return null;
        } else {

            Employee emp = employeeService.getEmployeeByEmpcode(Long.parseLong(empcode));

            if(emp == null){
                return null;
            } else{

                boolean isValidPassword = bCryptPasswordEncoder.matches(password, emp.getPassword());
                if(isValidPassword){
                    return emp;
                } else{
                    return null;
                }
            }
        }
    }

}
