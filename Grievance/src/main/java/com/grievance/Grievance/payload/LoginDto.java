package com.grievance.Grievance.payload;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDto {

	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "length should be in limit ")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;
	
	/**
	 * 
	 */
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param password
	 */
	public LoginDto(String email, String password) {
		super();
		this.email = email;
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
}
