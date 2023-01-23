package com.leavemanagment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.Employee;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.enumm.LeaveType;
import com.leavemanagment.exception.DuplicateEmployeeException;
import com.leavemanagment.exception.EmployeeNotFoundException;
import com.leavemanagment.exception.InsufficientLeaveBalanceException;
import com.leavemanagment.repo.EmployeeDetailsRepo;
import com.leavemanagment.repo.LeaveDetailsRepo;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	
	 @Autowired
	    private EmployeeDetailsRepo employeeRepository;
	 
@Autowired
private LeaveDetailsRepo leaveRepository;

	
	@Override
	public EmployeeDetails saveEmployee(EmployeeDetails employee) throws DuplicateEmployeeException {
		
		System.out.println(employee);
		   if(employeeRepository.existsById(employee.getEmployeeId()))
		   {
			   throw new DuplicateEmployeeException("Employee Already Exists");
		   }
		   else
		   {
			   return employeeRepository.save(employee);
		   }
		
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails employee) throws EmployeeNotFoundException {
		
		
		  if(employeeRepository.existsById(employee.getEmployeeId())) {
			  return employeeRepository.save(employee);
		  }
		  else
		  {
			 throw new EmployeeNotFoundException("Employee Not Found"); 
		  }
		
	}

	@Override
	public EmployeeDetails getEmployeeById(long employeeId) throws EmployeeNotFoundException {
		
		
		 
		return employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("No Employee Found"));
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public LeaveDetails applyLeave(long empId, String type, int noOfDays) {
		
		LeaveDetails leaveDeatils = new LeaveDetails();
		leaveDeatils.setEmployeeId(empId);
		leaveDeatils.setApproverId(0);
		leaveDeatils.setNoOfDays(noOfDays);
		System.out.println("EMPLOYEE SERVICE IMPL type: " + type);
		 if(type.equals("AUNNAL_LEAVE"))
		 {
			 leaveDeatils.setLeaveType(LeaveType.AUNNAL_LEAVE);
		 }
		 else if(type.equals("PATERNITY_LEAVE"))
		 {
			 leaveDeatils.setLeaveType(LeaveType.PATERNITY_LEAVE); 
		 }
		 else if (type.equals("MATERNITY_LEAVE"))
		 {
			 leaveDeatils.setLeaveType(LeaveType.MATERNITY_LEAVE); 
		 }
		 leaveDeatils.setStatus(LeaveStatus.SENT_TO_MANAGER);
		return leaveRepository.save(leaveDeatils);
	}

	@Override
	public String checkLeaveBalance(long empId)  throws EmployeeNotFoundException{
		
		
		
		
		 if(employeeRepository.existsById(empId))
		 {
			 
			 String leavebalance ="";
			 
			 EmployeeDetails emp = employeeRepository.findById(empId).get();
			 
			 
			     if(emp.getGender().equals("M"))
			     {
			    	 leavebalance+=" Anual Leaves: "+emp.getAnnualLeave()+" Peternity Leaves: "+emp.getPaternityLeave();
			     }
			     else
			     leavebalance+=" Anual Leaves:"+emp.getAnnualLeave()+" Meternity Leaves: "+emp.getMaternityLeave();
			     
			     
			     return leavebalance;
		 }
		 else {
			 
			 throw new EmployeeNotFoundException("Emplyee Not Found");
		 }
		
	}
	

}
