package com.leavemanagment.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.exception.LeaveNotFoundException;
import com.leavemanagment.repo.LeaveDetailsRepo;
@Service
public class ManagerServiceImple implements IManagerService{
	@Autowired
	private LeaveDetailsRepo leaveRepo;

	@Override
	@Transactional
	public LeaveDetails updateLeaveStatus(long empid, long leaveid,String status) throws LeaveNotFoundException {
		    
		LeaveDetails leaveDetails = leaveRepo.findByEmployeeIdAndLeaveId(empid, leaveid);
		
		if(leaveDetails!=null)
		{
			
			leaveDetails.setStatus(LeaveStatus.SENT_TO_HR);
			   if(status.equals("REJECTED")) {
        		   leaveDetails.setStatus(LeaveStatus.REJECTED);
			   }
			return leaveRepo.save(leaveDetails);
		}
		else
		{
			throw new LeaveNotFoundException("Leave not found");
		}
		
		
	}

	@Override
	public List<LeaveDetails> checkLeaveRequest() {
		
		return leaveRepo.findAll();
	}

}
