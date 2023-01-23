package com.leavemanagment.services;
import java.util.List;

import com.leavemanagment.entities.EmployeeDetails;
public interface LeaveDetailService {
	boolean medicalReport(long leaveId);

	 public List<EmployeeDetails> getAllEmployees();
}
