package com.leavemanagment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.exception.LeaveNotFoundException;
import com.leavemanagment.services.HRService;

@RestController
@RequestMapping("/lms/hr")
@CrossOrigin(origins = {"http://localhost:3000","*"}, allowedHeaders = "*")

public class HrController {
	@Autowired
	private HRService hrService;
	
	@PostMapping("/change-status")
	public ResponseEntity<LeaveDetails> updateStaus(@Valid @RequestParam("eid") long eid,@Valid @RequestParam("lid") long lid, @RequestParam("status") String status) throws LeaveNotFoundException
	{
		return new ResponseEntity<LeaveDetails>(hrService.updateLeaveStatus(eid, lid, status),HttpStatus.OK);
	}
	
	@GetMapping("/leave-requests")
	public List<LeaveDetails> checkLeaveRequests()
	{
		return hrService.checkReaveRequest();
	}
	
	@GetMapping("/medical/{lid}")
	public LeaveDetails validateMedicalReport(@PathVariable("lid") long lid) throws LeaveNotFoundException
	{
		return hrService.validateMedicalReport(lid);
	}
}
