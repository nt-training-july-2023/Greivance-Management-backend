package com.grievance.Grievance.OutDto;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.Comment;

public class UserDetailsOutDto {

	private long Id;
	private String name;
	private UserType userType;
	private String email;
	private Boolean isLoggedIn; 
	
	//department out dto
	private String department; 
	
	@JsonManagedReference
	private List<TicketOutDto> tickets;
	
    private List<Comment> comments;

	/**
	 * @return the id
	 */
	public long getsId() {
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
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the tickets
	 */
	public List<TicketOutDto> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<TicketOutDto> tickets) {
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
	public UserDetailsOutDto(long id, String name, UserType userType,
			@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$") String email, Boolean isLoggedIn,
			String department, List<TicketOutDto> tickets, List<Comment> comments) {
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
				+ ", isLoggedIn=" + isLoggedIn + ", comments="
				+ comments + "]";
	}

	

}
