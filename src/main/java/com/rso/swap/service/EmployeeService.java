package com.rso.swap.service;

import java.util.List;

import com.rso.swap.model.Employee;
import com.rso.swap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    // fetching all department
	public List<Employee> getAllEmployee(){
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}
	
	// fetching employee by id
	public Employee getEmployee(Long id){
		return employeeRepository.findOne(id);
	}

    // fetching employee by id
    public Employee getEmployeeByEmpcode(Long empcode){
        return employeeRepository.getEmployeeByEmpcode(empcode);
    }
	
	// inserting employee
	@Transactional
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	// updating employee by id
	@Transactional
	public void updateEmployee(Employee u, Long id){
		if(id == u.getEmpcode()) {
			employeeRepository.save(u);
		}
	}
	
	// deleting all users
	public void deleteAllUsers(){
		employeeRepository.deleteAll();
	}
	
	// deleting department by id
	public void deleteUserByID(Long id){
		employeeRepository.delete(id);
	}
	
	//patching/updating department by id
	/*public void patchDepartment(Employee d, int id) {
		if(id == d.getDepartment_ID()) {
			employeeRepository.save(d);
		}
	}*/

}
