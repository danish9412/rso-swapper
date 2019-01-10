package com.rso.swap.controller;

import java.util.List;
import java.util.Set;

import com.rso.swap.model.Shift;
import com.rso.swap.service.ShiftService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShiftController {
	
	static final Logger logger  = LogManager.getLogger(ShiftController.class.getName());

	@Autowired
	private ShiftService shiftService;
	
	// displaying list of all shifts
	@GetMapping("/shifts")
	public List<Shift> getAllShifts(){
		return shiftService.getAllShifts();
	}

	// displaying shifts by empcode
    @GetMapping("/shifts/{empcode}")
    public List<Shift> getShiftByEmpcode(@PathVariable("empcode") String empcode){
        return shiftService.getShiftByEmpcode(empcode);
    }

    // displaying shifts by empcode
    @GetMapping("/shifts/match")
    public List<Shift> getMatchedShifts(@RequestParam String empcode){
        return shiftService.getMatchedShifts(empcode);
    }
	
	// inserting shift
	@PostMapping("/shifts")
	public void addShift(@RequestBody Shift shift){
		shiftService.addShift(shift);
	}

	//updating employee by id
	//@PutMapping("/employees/{id}")
	/*public void updateEmployee(@RequestBody Shift e, @PathVariable int id){
		shiftService.updateEmployee(e, id);
	}*/
	
	// deleting all shifts
	@DeleteMapping("/shifts")
	public void deleteAllShifts(){
		shiftService.deleteAllShifts();
	}

	// deleting shifts by email
	/*@DeleteMapping("shifts/{email}")
	public void deleteShiftByEmail(@RequestBody String email){
		shiftService.deleteShiftsByEmail(email);
	}*/

	// updating/ patching employee by id
	/*@PatchMapping("employees/{id}")
	public void patchEmployeeByID(@RequestBody Shift e, @PathVariable int id) {
		shiftService.patchEmployee(e, id);
	}*/
}
