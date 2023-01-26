package com.leavemanagment.services;
import java.util.List;


import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.exception.LeaveNotFoundException;

public interface HRService {

	public List<LeaveDetails> checkReaveRequest();
	public LeaveDetails checkLeaveRequest(long leaveId) throws LeaveNotFoundException;
	public LeaveDetails updateLeaveStatus(long employeeid,long leaveid, String status) throws LeaveNotFoundException;
	
	public LeaveDetails validateMedicalReport(long leaveId) throws LeaveNotFoundException;
	public List<LeaveDetails> findStatusByEmployeeId(long employeeId);
	
}


