package com.leavemanagment.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.enumm.LeaveType;
import com.leavemanagment.exception.LeaveNotFoundException;
import com.leavemanagment.repo.EmployeeDetailsRepo;
import com.leavemanagment.repo.LeaveDetailsRepo;


@Service
public class HRServiceImpl implements HRService{

	@Autowired
	private LeaveDetailsRepo leaveRepo;
	@Autowired
	private EmployeeDetailsRepo employeeRepo;
	
	@Override
	public List<LeaveDetails> checkReaveRequest() {
		
		return leaveRepo.findAll();
	}

	@Override
	public LeaveDetails checkLeaveRequest(long leaveId) throws LeaveNotFoundException {
		
		  if(leaveRepo.existsById(leaveId))
		  {
			  return leaveRepo.findById(leaveId).get();
		  }
		  else
		  {
			  throw new LeaveNotFoundException("Leave Not found") ;
		  }
		
	}

	@Override
	public LeaveDetails updateLeaveStatus(long employeeid, long leaveid , String status) throws LeaveNotFoundException {
		
		
		
		  LeaveDetails leaveDetails = leaveRepo.findByEmployeeIdAndLeaveId(employeeid, leaveid);
		  
		   if(leaveDetails!=null) {
			  
			   EmployeeDetails employee = employeeRepo.findById(employeeid).get();
			   
			   
			   
			   switch (employee.getGender()) {
			   case "Male":
				
				   switch (leaveDetails.getLeaveType()) {
				case AUNNAL_LEAVE:
					
					
					int totalLeaves = employee.getAnnualLeave();
				
					 if(leaveDetails.getNoOfDays()>totalLeaves)
					 {
						 leaveDetails.setStatus(LeaveStatus.REJECTED);
	                	 leaveDetails.setComments("No Suffient leaves");
					 }
					 else
					 {
						 leaveDetails.setStatus(LeaveStatus.HR_APPROVED);
						 
						 employee.setAnnualLeave(totalLeaves-leaveDetails.getNoOfDays());
					 }
					
					
					
					break;
					
                 case MATERNITY_LEAVE:
                	 
                	 
                	 leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
                	 leaveDetails.setComments("Not Applicable for this leave type");
					
					break;
                 case PATERNITY_LEAVE:
                	 
                	 
                	 
                	 int totalPeternitityLeaves = employee.getPaternityLeave();
     				
					 if(leaveDetails.getNoOfDays()>totalPeternitityLeaves)
					 {
						 leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
	                	 leaveDetails.setComments("No Suffient leaves");
					 }
					 else
					 {
						 leaveDetails.setStatus(LeaveStatus.HR_APPROVED);
						 leaveDetails.setApproverId(employee.getHrld());
						 employee.setPaternityLeave(totalPeternitityLeaves-leaveDetails.getNoOfDays());
						 leaveDetails.setComments("approved by hr");
						 
					 }
					
 					
 					break;

				default:
					break;
				}
				
				break;

             case "Female":
            	 
            	 
       
            	  switch (leaveDetails.getLeaveType()) {
  				case AUNNAL_LEAVE:
  					
  					
  					int totalLeaves = employee.getAnnualLeave();
  				
  					 if(leaveDetails.getNoOfDays()>totalLeaves)
  					 {
  						 leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
  	                	 leaveDetails.setComments("No Suffient leaves");
  					 }
  					 else
  					 {
  						 leaveDetails.setStatus(LeaveStatus.HR_APPROVED);
  						 
  						 employee.setAnnualLeave(totalLeaves-leaveDetails.getNoOfDays());
  						 
  						leaveDetails.setApproverId(employee.getHrld());
  					 }
  					
  					
  					
  					break;
  					
                   case MATERNITY_LEAVE:
                  	 
                	   int meternityLeaves  = employee.getMaternityLeave();
                  	 
                  	  
                	   
                	   if( meternityLeaves < leaveDetails.getNoOfDays())
                	   {
                		   leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
    	                	 leaveDetails.setComments("No Suffient leaves");  
                	   }
                	   else
                	   {
                		   leaveDetails.setStatus(LeaveStatus.HR_APPROVED);
                		   employee.setMaternityLeave(meternityLeaves-leaveDetails.getNoOfDays());
                		   leaveDetails.setApproverId(employee.getHrld());
                	   }
  					
  					break;
                   case PATERNITY_LEAVE:
                  	 
                	   leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
                  	 leaveDetails.setComments("Not Applicable for this leave type");
                  	 
                  	
  					
   					
   					break;

  				default:
  					break;
  				}
  				
            	 
            	 
            	 
            	 
				
				break;
			default:
				break;
			}
			   if(status.equals("REJECTED")) {
        		   leaveDetails.setStatus(LeaveStatus.HR_REJECTED);
			   }
			   employeeRepo.save(employee);
			   
		   }
		   else
		   {
			   throw new LeaveNotFoundException("Leave Not found") ;   
		   }
		   
		   
		   
		return leaveRepo.save(leaveDetails);
	}

	@Override
	public LeaveDetails validateMedicalReport(long leaveId) throws LeaveNotFoundException {
		
		
		
		  if(leaveRepo.existsById(leaveId))
		  {
			  LeaveDetails leaveDetails = leaveRepo.findById(leaveId).get();
			  
			  leaveDetails.setMedicalreport(1);
			  return leaveRepo.save(leaveDetails);
		  }
		  else
		  {
			  throw new LeaveNotFoundException("Leave Not found") ;   
		  }
		
	}
	 
	 @Override
	 public List<LeaveDetails> findStatusByEmployeeId(long employeeId) {
	        return leaveRepo.findStatusByEmployeeId(employeeId);
	    }
		
	}

	

	