package com.leavemanagment.services;

import java.util.List;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.LeaveType;
import com.leavemanagment.exception.DuplicateEmployeeException;
import com.leavemanagment.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	public EmployeeDetails saveEmployee(EmployeeDetails employee) throws DuplicateEmployeeException;
	public EmployeeDetails updateEmployee(EmployeeDetails employee) throws EmployeeNotFoundException;
	
	public EmployeeDetails getEmployeeById(long employeeId) throws EmployeeNotFoundException;
	
	public List<EmployeeDetails> getAllEmployees();
	
//	public LeaveDetails applyLeave(long empId,int type,int noOfDays);
	
	public String checkLeaveBalance(long empId) throws EmployeeNotFoundException;
	public LeaveDetails applyLeave(long eid, String type, int days);

}
