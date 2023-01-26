package com.leavemanagment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagment.entities.LeaveDetails;

public interface LeaveDetailsRepo extends JpaRepository<LeaveDetails,Long>{
	
	
	public LeaveDetails findByEmployeeIdAndLeaveId(long empid, long leaveid);

	public List<LeaveDetails> findStatusByEmployeeId(long empid);
}
