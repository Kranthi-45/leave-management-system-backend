package com.leavemanagment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagment.entities.AppUser;
import com.leavemanagment.entities.Login;
import com.leavemanagment.entities.LoginResult;
import com.leavemanagment.exception.AppUserException;
import com.leavemanagment.repo.AppUserRepo;
@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserRepo userRep;

	@Override
	public AppUser saveAppUserEntity(AppUser appuser) throws AppUserException {
		
		
		Optional<AppUser> userOptional = userRep.findByUsername(appuser.getUsername());
		
		   if(userOptional.isPresent())
		   {
			   throw new AppUserException("User Already exists");
		   }
		   else
		   {
			   return userRep.save(appuser);
		   }
		
		

	}

	@Override
	public LoginResult validateUserLogin(Login login) {
		
		LoginResult result = new LoginResult();
		
		 Optional<AppUser >  userOptional = userRep.findByUsername(login.getUsername());
		
		 
		  if(userOptional.isPresent())
		  {
			  
			  AppUser user = userOptional.get();
			  
			   if(user.getPassword().equals(login.getPassword()))
			   {
				   result.setLoginMessage("Login Success");
				   result.setRole(user.getRole());
				   result.setUserId(user.getUserid());
				   result.setUserName(user.getUsername());
			   }
			   else
			   {
				   result.setLoginMessage("Invalid Password"); 
			   }
			  
		  }
		  else
		  {
			  result.setLoginMessage("InvalidUser");  
		  }
		
		return result;
	}

}
