package com.grievance.Grievance.InDto;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;

public class TicketInDto {
	//status
	
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;
	
	@NotEmpty(message = "Title is required")
	private String ticketTitle;
	
	@NotEmpty(message = "Must add description")
	private String description;
		
	private Department department;
	
	private UserDetails userDetails;
	
    private List<Comment> comments;

	/**
	 * @return the ticketType
	 */
	public TicketType getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the ticketTitle
	 */
	public String getTicketTitle() {
		return ticketTitle;
	}

	/**
	 * @param ticketTitle the ticketTitle to set
	 */
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
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
	 * @param ticketType
	 * @param ticketTitle
	 * @param description
	 * @param department
	 * @param userDetails
	 * @param comments
	 */
	public TicketInDto(TicketType ticketType, @NotEmpty(message = "Title is required") String ticketTitle,
			@NotEmpty(message = "Must add description") String description, Department department,
			UserDetails userDetails, List<Comment> comments) {
		super();
		this.ticketType = ticketType;
		this.ticketTitle = ticketTitle;
		this.description = description;
		this.department = department;
		this.userDetails = userDetails;
		this.comments = comments;
	}

	/**
	 * 
	 */
	public TicketInDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
