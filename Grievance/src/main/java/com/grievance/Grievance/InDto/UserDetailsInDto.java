package com.grievance.Grievance.InDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.Department;

public class UserDetailsInDto {
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	@NotEmpty(message = "Email (Username) is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	private String email;
	
	 @NotNull(message = "Department can not be null")
	 private Department department;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
