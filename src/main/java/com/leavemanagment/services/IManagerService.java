package com.leavemanagment.services;

import java.util.List;

import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.exception.LeaveNotFoundException;

public interface IManagerService {
	
//	public LeaveDetails updateLeaveStatus(long empid, long leaveid) throws LeaveNotFoundException;
    public List<LeaveDetails> checkLeaveRequest();
    public LeaveDetails updateLeaveStatus(long empid, long leaveid, String status) throws LeaveNotFoundException;


}
