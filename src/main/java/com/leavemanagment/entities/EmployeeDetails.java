package com.leavemanagment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeDetails")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long employeeId;
	private String employeeName;
	private long managerId;
	private long hrld;
	private String gender;
	private int annualLeave;
	private int paternityLeave;
	private  int maternityLeave;
		
	public EmployeeDetails() {
		super();
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public long getManagerId() {
		return managerId;
	}


	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}


	public long getHrld() {
		return hrld;
	}


	public void setHrld(long hrld) {
		this.hrld = hrld;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAnnualLeave() {
		return annualLeave;
	}


	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}


	public int getPaternityLeave() {
		return paternityLeave;
	}


	public void setPaternityLeave(int paternityLeave) {
		this.paternityLeave = paternityLeave;
	}


	public int getMaternityLeave() {
		return maternityLeave;
	}


	public void setMaternityLeave(int maternityLeave) {
		this.maternityLeave = maternityLeave;
	}


	public EmployeeDetails(long employeeId, String employeeName, long managerId, long hrld, String gender,
			int annualLeave, int paternityLeave, int maternityLeave) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.managerId = managerId;
		this.hrld = hrld;
		this.gender = gender;
		this.annualLeave = annualLeave;
		this.paternityLeave = paternityLeave;
		this.maternityLeave = maternityLeave;
	}


	

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeName=" + employeeName + ", managerId="
				+ managerId + ", hrld=" + hrld + ", gender=" + gender + ", annualLeave=" + annualLeave
				+ ", paternityLeave=" + paternityLeave + ", maternityLeave=" + maternityLeave + "]";
	}
	

}
