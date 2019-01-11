package com.rso.swap.repository;

import com.rso.swap.model.Employee;
import com.rso.swap.model.Shift;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

    @Query(value = "SELECT * FROM employee e where e.empcode = :empcode", nativeQuery = true)
    Employee getEmployeeByEmpcode(@Param("empcode") Long empcode);

}
