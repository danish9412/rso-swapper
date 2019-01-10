package com.rso.swap.service;

import java.util.*;

import com.rso.swap.model.Shift;
import com.rso.swap.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

// employee service class
@Service
public class ShiftService {
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	// fetching all shifts
	public List<Shift> getAllShifts(){
		List<Shift> shifts = (List<Shift>) shiftRepository.findAll();
		return shifts;
	}
	
	// fetching shifts by email
	public List<Shift> getShiftByEmpcode(String empcode){
		return shiftRepository.findByEmpcode(empcode);
	}
	
	// inserting shift
	public void addShift(Shift s) {
		shiftRepository.save(s);
	}
	
	/*// updating shift by email
	public void updateEmployee(Employee emp, int id){
		if(id == emp.getEmployeeID()) {
			shiftRepository.save(emp);
		}
	}*/

	public List<Shift> getMatchedShifts(String empcode){
        List<Shift> allShifts = getAllShifts();
        List<Shift> myShifts = getShiftByEmpcode(empcode);
        List<Shift> matchedShifts = new ArrayList<Shift>();

        for(Shift shift : allShifts){
            for(Shift myShift : myShifts){
                if (shiftMatcher(myShift.getGive(), shift.getNeed())){
                    matchedShifts.add(shift);
                }
            }
        }
        return matchedShifts;
    }

    private boolean shiftMatcher(String give, String need){
	    boolean matched = false;
        List<String> allNeedShifts = Arrays.asList(need.split(","));

        for(String needShift : allNeedShifts){
            if(needShift.equalsIgnoreCase(give))
                matched = true;
        }
        return matched;
    }
	// deleting all shifts
	public void deleteAllShifts(){
		shiftRepository.deleteAll();
	}
	
	// deleting shifts by email
	/*public void deleteShiftsByEmail(String email){
		shiftRepository.delete(email);
	}*/


	
	/*//patching/updating employee by id
	public void patchEmployee(Employee emp, int id) {
		if(id == emp.getEmployeeID()) {
			shiftRepository.save(emp);
		}
	}*/
}
