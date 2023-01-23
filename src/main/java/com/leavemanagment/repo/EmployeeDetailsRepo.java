package com.leavemanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagment.entities.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Long> {

}
