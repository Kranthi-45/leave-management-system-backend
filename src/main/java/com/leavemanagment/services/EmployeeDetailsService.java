package com.leavemanagment.services;

import java.util.List;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.exception.EmployeeNotFoundException;
import com.leavemanagment.exception.InsufficientLeaveBalanceException;

public interface EmployeeDetailsService {
	public LeaveStatus checkLeaveStatus(long leaveId) throws EmployeeNotFoundException;
	public  int checkLeaveBalance(long employeeId) throws EmployeeNotFoundException;
	public  void applyLeave(long employeeId,int numberOfDays) throws InsufficientLeaveBalanceException, EmployeeNotFoundException;
	public  EmployeeDetails addemployee(EmployeeDetails employeeId);
	public LeaveDetails addLeaveDetails(LeaveDetails leaveDetails);
	public List<EmployeeDetails> viewAllLeaves();
}
