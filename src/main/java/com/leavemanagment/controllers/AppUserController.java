package com.leavemanagment.controllers;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagment.entities.AppUser;
import com.leavemanagment.entities.Login;
import com.leavemanagment.entities.LoginResult;
import com.leavemanagment.exception.AppUserException;
import com.leavemanagment.services.AppUserService;

@RestController
@RequestMapping("/lms")
@CrossOrigin(origins = {"http://localhost:3000","*"}, allowedHeaders = "*")
public class AppUserController {

	  @Autowired 
	  AppUserService userloginservice;

	  

	    @PostMapping("/register")
	   // @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<AppUser> saveUserLogin(@Valid @RequestBody AppUser userlogin) throws AppUserException
	    {
	        AppUser appuser=userloginservice.saveAppUserEntity(userlogin);
	        return new ResponseEntity<AppUser>(appuser,HttpStatus.CREATED);
	    }
	    @PostMapping("/login")
	    public ResponseEntity<LoginResult> validateUserLogin(@Valid @RequestBody Login login)
	    {  
	        
	    	return new ResponseEntity<LoginResult>(userloginservice.validateUserLogin(login), HttpStatus.OK);
	    }

	 

	 
}
