package com.leavemanagment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagment.entities.AppUser;

public  interface  AppUserRepo extends JpaRepository<AppUser, String>
{
	
	
	public Optional<AppUser> findByUsername(String username);
}