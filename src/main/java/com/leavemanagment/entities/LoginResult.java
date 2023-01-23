package com.leavemanagment.entities;

import com.leavemanagment.enumm.Role;

public class LoginResult {
	
	private String loginMessage;
	
	private Role role;

	private long userId;
	
	private String userName;
	
	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long l) {
		this.userId = l;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginResult(String loginMessage, Role role) {
		super();
		this.loginMessage = loginMessage;
		this.role = role;
	}

	public LoginResult(String loginMessage, Role role, long userId) {
		super();
		this.loginMessage = loginMessage;
		this.role = role;
		this.userId = userId;
	}

	public LoginResult(String loginMessage, Role role, long userId, String userName) {
		super();
		this.loginMessage = loginMessage;
		this.role = role;
		this.userId = userId;
		this.userName = userName;
	}

	public LoginResult() {
		super();
	}
	
	
	

}
