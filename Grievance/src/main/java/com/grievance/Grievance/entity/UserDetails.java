package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	@NotEmpty(message = "Name is required")
	private String name;

	
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@NotEmpty(message = "Password is required")
	@Size(min = 5, message = "Password should be at least 5 characters")
	private String password;

	@NotEmpty(message = "Email (Username) is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	
	@Column(unique = true)
	@NotEmpty(message = "Email is required")
	private String email;

	private Boolean isLoggedIn;
	
	// Many users can have one department

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deptId")
	@JsonBackReference
//	@JsonIgnore
	private Department department;

	// One user can have many tickets.
	@OneToMany(mappedBy = "userDetails")
	@JsonManagedReference
	private List<Ticket> tickets;

	// one user can have multiple comments

	@OneToMany(mappedBy = "userDetails")
	@JsonManagedReference
	private List<Comment> comments;

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
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the password
	 */ //?
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
	
	

	/**
	 * @return the isLoggedInBoolean
	 */
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * @param isLoggedInBoolean the isLoggedInBoolean to set
	 */
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	/**
	 * 
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param userType
	 * @param password
	 * @param email
	 * @param isLoggedIn
	 * @param department
	 * @param tickets
	 * @param comments
	 * @param isLoggedIn 
	 */
	public UserDetails(long id, @NotEmpty(message = "Name is required") String name, UserType userType,
			@NotEmpty(message = "Password is required") @Size(min = 5, message = "Password should be at least 8 characters") String password,
			@NotEmpty(message = "Email (Username) is required") @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$") String email,
			 Department department, List<Ticket> tickets,
			List<Comment> comments, Boolean isLoggedIn) {
		super();
		Id = id;
		this.name = name;
		this.userType = userType;
		this.password = password;
		this.email = email;
		this.isLoggedIn = isLoggedIn;
		this.department = department;
		this.tickets = tickets;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "UserDetails [Id=" + Id + ", name=" + name + ", userType=" + userType + ", password=" + password
				+ ", email=" + email + ", isLoggedIn=" + isLoggedIn + ", department=" + department + ", tickets="
				+ tickets + ", comments=" + comments + "]";
	}

}
