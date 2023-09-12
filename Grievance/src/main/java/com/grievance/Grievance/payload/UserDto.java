package com.grievance.Grievance.payload;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserType;

public class UserDto {

	private long Id;
	@NotEmpty(message = "Name is required")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 5, message = "Password should be at least 8 characters")
	private String password;
	
	@NotEmpty(message = "Email (Username) is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@Column(unique = true)
	private String email;
	
	private Boolean isLoggedIn;
	
	//Many users can have one department 
	@ManyToOne
    private Department department;

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	/**
	 * @return the isLoggedIn
	 */
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * @param isLoggedIn the isLoggedIn to set
	 */
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	/**
	 * @param id
	 * @param name
	 * @param userType
	 * @param password
	 * @param department
	 * @param email
	 */
	public UserDto(long id, String name, UserType  userType, String password, String email,Department department,Boolean isLoggedIn) {
		super();
		Id = id;
		this.name = name;
		this.userType = userType;
		this.password = password;
		this.department = department;
		this.email = email;
		this.isLoggedIn = isLoggedIn;
	
	}

	/**
	 * 
	 */
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType  userType) {
		this.userType = userType;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
