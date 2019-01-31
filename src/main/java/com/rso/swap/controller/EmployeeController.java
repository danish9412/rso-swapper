package com.rso.swap.controller;

import java.util.List;

import com.rso.swap.model.Employee;
import com.rso.swap.service.EmployeeService;
import com.rso.swap.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String isValidUser(Model model, HttpServletRequest request){
        //HttpSession session = request.getSession();
        String empcode = request.getParameter("empcode");
        String password = request.getParameter("password");
        //String ses = request.getSession().getAttribute("empcode").toString();
        Employee employee = loginService.validateEmployee(empcode, password);
        if(employee == null){
            //session.setAttribute("message","Sorry! Wrong username/password. Try Again!");
            return "403";
        }
        model.addAttribute("empcode", empcode);
        model.addAttribute("empName", employee.getName());
        //session.setAttribute("empcode",empcode);
        return "welcome";
    }

    // displaying list of all users
    @GetMapping("/employees")
    private List<Employee> getAllUsers(){
        return employeeService.getAllEmployee();
    }

    // displaying employee by id
    @GetMapping("/employees/{id}")
    public Employee getUser(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    // inserting employee
    @PostMapping("/employees")
    public void addUser(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    //updating employee by id
    @PutMapping("/employees/{id}")
    public void updateUser(@RequestBody Employee u, @PathVariable Long id){
        employeeService.updateEmployee(u, id);
    }

    // deleting all department
    @DeleteMapping("/employees")
    public void deleteAllUsers(){
        employeeService.deleteAllUsers();
    }

    // deleting department by id
    @DeleteMapping("employees/{id}")
    public void deleteDepartmentByID(@PathVariable Long id){
        employeeService.deleteUserByID(id);
    }

    // updating/ patching department by id
		/*@PatchMapping("departments/{id}")
		public void patchDepartmentByID(@RequestBody Employee d, @PathVariable int id) {
			userService.patchDepartment(d, id);
		}*/
}
