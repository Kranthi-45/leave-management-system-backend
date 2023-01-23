package com.leavemanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagment.entities.LeaveDetails;

public interface LeaveDetailsRepo extends JpaRepository<LeaveDetails,Long>{
	
	
	public LeaveDetails findByEmployeeIdAndLeaveId(long empid, long leaveid);
}
