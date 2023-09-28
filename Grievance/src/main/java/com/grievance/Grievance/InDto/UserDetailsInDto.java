package com.grievance.Grievance.InDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.Department;

/**
 * Represents the input data for creating or updating user details.
 */
public class UserDetailsInDto {

	/**
	 * The name of the user.
	 */
	@NotEmpty(message = "Name is required")
	private String name;

	/**
	 * The user type (e.g., Admin, Member).
	 */
	@Enumerated(EnumType.STRING)
	private UserType userType;

	/**
	 * The user's password.
	 */
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	/**
	 * The user's email (username).
	 */
	@NotEmpty(message = "Email (Username) is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	private String email;

	/**
	 * The department to which the user belongs.
	 */
	@NotNull(message = "Department can not be null")
	private Department department;

	/**
	 * Gets the name of the user.
	 *
	 * @return The user's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 *
	 * @param name The user's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user type.
	 *
	 * @return The user type (Admin, Member).
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * Sets the user type.
	 *
	 * @param userType The user type (Admin, Member).
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return The user's password.
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password The user's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user's email (username).
	 *
	 * @return The user's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email (username).
	 *
	 * @param email The user's email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the department to which the user belongs.
	 *
	 * @return The user's department.
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets the department to which the user belongs.
	 *
	 * @param department The user's department.
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
}
