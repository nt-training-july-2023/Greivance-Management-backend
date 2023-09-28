package com.grievance.Grievance.InDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents the input data for changing a user's password.
 */
public class ChangePasswordInDto {

	/**
	 * The old password of the user.
	 */
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String oldPassword;

	/**
	 * The new password for the user.
	 */
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String newPassword;
	/**
	 * The email address of the user.
	 */
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@NotEmpty(message = "Email is required")
	private String email;

	/**
	 * Gets the old password of the user.
	 *
	 * @return The old password.
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets the old password of the user.
	 *
	 * @param oldPassword The old password.
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Gets the new password for the user.
	 *
	 * @return The new password.
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the new password for the user.
	 *
	 * @param newPassword The new password.
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Gets the email address of the user.
	 *
	 * @return The email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 *
	 * @param email The email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
