package com.leavemanagment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.exception.LeaveNotFoundException;
import com.leavemanagment.services.IManagerService;

@RestController
@RequestMapping("/lms/manager")
@CrossOrigin(origins = {"http://localhost:3000","*"}, allowedHeaders = "*")
public class ManagerController {
	
	@Autowired
	private IManagerService managerService;
	
	@PostMapping("/change-leave-status")
	public ResponseEntity<LeaveDetails> updateStaus(@Valid @RequestParam("eid") long eid,@Valid @RequestParam("lid") long lid, @RequestParam("status") String status) throws LeaveNotFoundException
	{
		return new ResponseEntity<LeaveDetails>(managerService.updateLeaveStatus(eid, lid, status),HttpStatus.OK);
	}
	
	
	@GetMapping("/check-leave-requests")
	public List<LeaveDetails> checkLeaveRequests()
	{
		return managerService.checkLeaveRequest();
	}
	
}
