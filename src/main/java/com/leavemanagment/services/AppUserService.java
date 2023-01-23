package com.leavemanagment.services;

import com.leavemanagment.entities.AppUser;
import com.leavemanagment.entities.Login;
import com.leavemanagment.entities.LoginResult;
import com.leavemanagment.exception.AppUserException;

public interface AppUserService {
	public AppUser saveAppUserEntity( AppUser appuser) throws AppUserException;
    public LoginResult validateUserLogin(Login login);



 }


