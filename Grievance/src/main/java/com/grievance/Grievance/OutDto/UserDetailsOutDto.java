package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.Enum.UserType;

/**
 * Represents the output data for the User.
 */
public class UserDetailsOutDto {
	/**
	 * Unique identifier for the user.
	 */
	private long Id;
	/**
	 * The name of the user.
	 */
	private String name;

	/**
	 * The type of the user (e.g., Admin or Member).
	 */
	private UserType userType;
	/**
	 * The email address of the user.
	 */
	private String email;
	/**
	 * Flag indicating whether the user is currently logged in.
	 */
	private Boolean isLoggedIn;

	private String password;

	/**
	 * The department to which the user belongs.
	 */
	private String department;

	/**
	 * The list of tickets associated with the user.
	 */
	@JsonManagedReference(value = "user")
	private List<TicketOutDto> tickets;

	private List<CommentOutDto> comments;

	/**
	 * Gets the unique identifier for the user.
	 *
	 * @return The user's unique identifier.
	 */
	public long getId() {
		return Id;
	}

	/**
	 * Sets the unique identifier for the user.
	 *
	 * @param userId The user's unique identifier.
	 */
	public void setId(long id) {
		Id = id;
	}

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
	 * Gets the type of the user (e.g., Admin or Member).
	 *
	 * @return The user's type.
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * Sets the type of the user (e.g., Admin or Member).
	 *
	 * @param usertype The user's type.
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * Gets the email address of the user.
	 *
	 * @return The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 *
	 * @param email The user's email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Checks if the user is currently logged in.
	 *
	 * @return `true` if the user is logged in, `false` otherwise.
	 */
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * Sets whether the user is currently logged in.
	 *
	 * @param isLoggedIn `true` if the user is logged in, `false` otherwise.
	 */
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	/**
	 * Gets the department to which the user belongs.
	 *
	 * @return The user's department.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department to which the user belongs.
	 *
	 * @param department The user's department.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the list of tickets associated with the user.
	 *
	 * @return The list of tickets.
	 */
	public List<TicketOutDto> getTickets() {
		return tickets;
	}

	/**
	 * Sets the list of tickets associated with the user.
	 *
	 * @param tickets The list of tickets.
	 */
	public void setTickets(List<TicketOutDto> tickets) {
		this.tickets = tickets;
	}

	public List<CommentOutDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentOutDto> comments) {
		this.comments = comments;
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
