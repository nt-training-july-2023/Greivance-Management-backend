package com.grievance.Grievance.InDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ChangePasswordInDto {

	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String oldPassword;

	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String newPassword;

	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@NotEmpty(message = "Email is required")
	private String email;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
