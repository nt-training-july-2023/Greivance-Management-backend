package com.grievance.Grievance.OutDto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserType;

public class UserDetailsOutDto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	@NotEmpty(message = "Name is required")
	private String name;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	@NotEmpty(message = "Email (Username) is required")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@Column(unique = true)
	private String email;

	private Boolean isLoggedIn;
	
	// Many users can have one department
	private Department department;

	// One user can have many tickets.
	private List<Ticket> tickets;

	// one user can have multiple comments
	private List<Comment> comments;

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
	 * @param id
	 * @param name
	 * @param userType
	 * @param email
	 * @param isLoggedIn
	 * @param department
	 * @param tickets
	 * @param comments
	 */
	public UserDetailsOutDto(long id, @NotEmpty(message = "Name is required") String name, UserType userType,
			@NotEmpty(message = "Email (Username) is required") @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$") String email,
			Boolean isLoggedIn, Department department, List<Ticket> tickets, List<Comment> comments) {
		super();
		Id = id;
		this.name = name;
		this.userType = userType;
		this.email = email;
		this.isLoggedIn = isLoggedIn;
		this.department = department;
		this.tickets = tickets;
		this.comments = comments;
	}

	/**
	 * 
	 */
	public UserDetailsOutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDetailsOutDto [Id=" + Id + ", name=" + name + ", userType=" + userType + ", email=" + email
				+ ", isLoggedIn=" + isLoggedIn + ", department=" + department + ", tickets=" + tickets + ", comments="
				+ comments + "]";
	}
	
	

}
