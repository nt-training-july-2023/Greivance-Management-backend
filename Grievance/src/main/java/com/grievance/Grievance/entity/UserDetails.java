package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.Enum.UserType;

/**
 * Represents a user's details in the system.
 */
@Entity
public class UserDetails {

	/**
	 * Unique identifier for the user.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;

	/**
	 * The name of the user.
	 */
	@NotEmpty(message = "name is required")
	private String name;

	/**
	 * One-to-many relationship mapping to associate this entity with a list of Comment entities.
	 * This field represents the list of comments associated with this entity.
	 */
	@OneToMany(mappedBy = "userDetails")
	private List<Comment> comments;

	/**
	 * The email address of the user.
	 */
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@NotEmpty(message = "Email is required")
	private String email;

	/**
	 * The password of the user.
	 */
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	/**
	 * The type of the user (e.g., Admin or Member).
	 */
	@Enumerated(EnumType.STRING)
	private UserType usertype;

	/**
	 * Flag indicating whether the user is currently logged in.
	 */
	private Boolean isLoggedIn = false;

	/**
	 * The department to which the user belongs.
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department department;

	/**
	 * The list of tickets associated with the user.
	 */
	@JsonManagedReference(value = "user")
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ticket> tickets;

	/**
	 * Gets the unique identifier for the user.
	 *
	 * @return The user's unique identifier.
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the unique identifier for the user.
	 *
	 * @param userId The user's unique identifier.
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * Gets the password of the user.
	 *
	 * @return The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the password of the user.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the type of the user (e.g., Admin or Member).
	 *
	 * @return The user's type.
	 */
	public UserType getUsertype() {
		return usertype;
	}

	/**
	 * Sets the type of the user (e.g., Admin or Member).
	 *
	 * @param usertype The user's type.
	 */
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
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

	/**
	 * Gets the list of tickets associated with the user.
	 *
	 * @return The list of tickets.
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Sets the list of tickets associated with the user.
	 *
	 * @param tickets The list of tickets.
	 */

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * Constructs a new UserDetails object with the provided information.
	 *
	 * @param userId     The unique identifier of the user.
	 * @param name       The name of the user.
	 * @param email      The email address of the user.
	 * @param password   The user's password.
	 * @param usertype   The user's type (e.g., Admin or Member).
	 * @param isLoggedIn Whether the user is currently logged in.
	 * @param department The department to which the user belongs.
	 * @param tickets    The list of tickets associated with the user.
	 */
	public UserDetails(long userId, @NotEmpty(message = "name is required") String name,
			@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	        @NotEmpty(message = "Email is required") String email,
			@NotEmpty(message = "Password is required") String password, UserType usertype, Boolean isLoggedIn,
			Department department, List<Ticket> tickets) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.isLoggedIn = isLoggedIn;
		this.department = department;
		this.tickets = tickets;
	}

	/**
	 * Default constructor for creating a new.
     * UserDetails instance.
	 * Initializes the object with default values.
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Returns a string representation of the UserDetails object.
	 *
	 * @return A string containing the details of the UserDetails object.
	 */
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name +
				", email=" + email + ", password=" + password +
				", usertype=" + usertype + ", isLoggedIn=" + isLoggedIn +
				", department=" + department + ", tickets=" + tickets + "]";
	}

}
