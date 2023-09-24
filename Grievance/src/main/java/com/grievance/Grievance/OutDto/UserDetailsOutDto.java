package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.Enum.UserType;

public class UserDetailsOutDto {

	private long Id;
	private String name;
	private UserType userType;
	private String email;
	private Boolean isLoggedIn;

	private String department;

	@JsonManagedReference(value = "user")
	private List<TicketOutDto> tickets;

	private List<CommentOutDto> comments;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<TicketOutDto> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketOutDto> tickets) {
		this.tickets = tickets;
	}

	public List<CommentOutDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentOutDto> comments) {
		this.comments = comments;
	}

}
