package com.leavemanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leavemanagment.entities.LeaveDetails;

@Repository
public interface HRServiceRepo extends JpaRepository<LeaveDetails, Long> {

}