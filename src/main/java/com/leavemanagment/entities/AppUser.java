package com.leavemanagment.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.leavemanagment.enumm.Role;

@Entity
@Table(name="AppUser")

public class AppUser {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long userid;
		@Column(unique = true)
//		@Email(message = "Invalid Email Id")
//		@Range(min=1, max=12 , message="10 digits only allowed")
//		@Min(3)
//		@Min( value=3, message="minium 3 characters allowed")
//		@Max( value=5, message="Maximum 5 characters allowed")
// 		@Pattern(regexp = "B{1}[0-9]{5}", message = "Branch Id must follow B99999 pattern")
//      @NotBlank
//      @NotBlank(message = "UserName is required")
		
		
		@Pattern(regexp = "^[a-zA-Z0-9_.]+$",message = "Only Alphbets & Numbers are allowed" )
		@NotNull(message = "UserName is required")
		private String username;
		
		@NotNull(message = "Password is required")
//		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$",
        message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
		@Size(min = 5, message = "Password be atleast 5 characters")
		private String password;
		
		@NotNull(message = "Role is required")
		private Role  role;
		
		@NotNull(message = "Mobile Number is required")
		private long mobileNumber;
		
		public long getUserid() {
			return userid;
		}
		public void setUserid(long userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public AppUser() {
			super();
		}
		public AppUser(long userid, String username, String password, Role role, long mobileNumber) {
			super();
			this.userid = userid;
			this.username = username;
			this.password = password;
			this.role = role;
			this.mobileNumber = mobileNumber;
		}
		@Override
		public String toString() {
			return "AppUser [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role
					+ ", mobileNumber=" + mobileNumber + "]";
		}
		
		
		
		
		
	
		
		
	}


