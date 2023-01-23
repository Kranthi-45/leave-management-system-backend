package com.leavemanagment.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.Employee;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.exception.DuplicateEmployeeException;
import com.leavemanagment.exception.EmployeeNotFoundException;
import com.leavemanagment.services.EmployeeDetailsService;
import com.leavemanagment.services.EmployeeService;



@RestController
@RequestMapping("/lms/emp")
@CrossOrigin(origins = {"http://localhost:3000","*"}, allowedHeaders = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save-emp")
	public ResponseEntity<EmployeeDetails> createNewEmployee(@Valid @RequestBody EmployeeDetails employee) throws DuplicateEmployeeException
	{
		
		System.out.println(employee);
		
		return new ResponseEntity<EmployeeDetails>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/update-emp")
	public ResponseEntity<EmployeeDetails> updateEmployee(@Valid @RequestBody EmployeeDetails employee) throws DuplicateEmployeeException, EmployeeNotFoundException
	{
		
		return new ResponseEntity<EmployeeDetails>(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable("id") long id) throws EmployeeNotFoundException
	{
		return new ResponseEntity<EmployeeDetails>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	@GetMapping("/employees")
	public List<EmployeeDetails> getEmployeeDetails()
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/apply-leave")
	public ResponseEntity<LeaveDetails> applyForLeave(@Valid @RequestParam("empid") long eid,@Valid @RequestParam("type") String type,@Valid@RequestParam("days") int days )
	{
		System.out.println("type: " + type);
		return new ResponseEntity<LeaveDetails>(employeeService.applyLeave(eid, type, days), HttpStatus.CREATED);
	}
	
	@GetMapping("/leave-balance/{eid}")
	public ResponseEntity<String> checkLeaveBalance(@PathVariable("eid") long eid) throws EmployeeNotFoundException
	{	
		return new ResponseEntity<String>(employeeService.checkLeaveBalance(eid),HttpStatus.OK);
	}
	
}
