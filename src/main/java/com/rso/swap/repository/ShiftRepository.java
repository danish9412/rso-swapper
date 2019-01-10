package com.rso.swap.repository;

import com.rso.swap.model.Shift;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// interface extending crud repository
public interface ShiftRepository extends CrudRepository<Shift, Long> {

    @Query(value = "SELECT * FROM shift s where s.empcode = :empcode", nativeQuery = true)
    List<Shift> findByEmpcode(@Param("empcode") String empcode);

    /*@Query(value = "INSERT email, give, need, employee FROM shift s where s.email = :email", nativeQuery = true)
    List<Shift> addShift(@Param("email") String email);*/

    /*@Query(nativeQuery = true, value = "SELECT give, need FROM shift WHERE shift_id = :shiftId")
    List<Shift> findByUserId(@Param("shiftId") int userId);*/
}
