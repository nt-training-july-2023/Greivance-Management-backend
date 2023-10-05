package com.grievance.Grievance.InDto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents the input data for user login.
 */
public class LoginInDto {
	/**
	 * The user's email address.
	 */
	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@Column(unique = true)
	private String email;
	/**
	 * The user's password.
	 */
	@NotEmpty(message = "length should be in limit ")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	/**
	 * Gets the user's email address.
	 *
	 * @return The email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email address.
	 *
	 * @param email The email address.
	 */
	public void setEmail(String email) {
		this.email = email;
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

}
