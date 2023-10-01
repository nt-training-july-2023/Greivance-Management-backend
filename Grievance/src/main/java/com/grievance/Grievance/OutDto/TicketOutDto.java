package com.grievance.Grievance.OutDto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Comment;

/**
 * Represents the output data for the Ticket.
 */
public class TicketOutDto {

	 /**
     * The unique identifier for the ticket.
     */
	private long ticketId;

	   /**
     * The type of the ticket (e.g., Grievance, Feedback).
     */
	private TicketType ticketType;

	  /**
     * The status of the ticket (e.g., Open, Being_Addressed, Resolved).
     */
	private TicketStatus ticketStatus;

	 /**
     * The title of the ticket.
     */
	private String ticketTitle;

	  /**
     * The description of the ticket.
     */
	private String description;

	 /**
     * The date and time when the ticket was created.
     */
	private java.util.Date createdAt;

	 /**
     * The date and time when the ticket was last updated.
     */
	private java.util.Date updatedAt;

    /**
     * The department associated with the ticket.
     */
	@JsonBackReference(value = "dep")
	private DepartmentOutDto department;
	 /**
     * The user details associated with the ticket.
     */
	@JsonBackReference(value = "user")
	private UserDetailsOutDto userDetails;
	/**
     * The list of comments associated with the ticket.
     */
	private List<Comment> comments;
	
	private String deptName;
	
	private String name;
	
	private long userId;
	
	private long deptId;
	
	
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
     * Returns the unique identifier for the ticket.
     */
	public long getTicketId() {
		return ticketId;
	}

	/**
	 * Sets the unique identifier for this ticket.
	 *
	 * @param ticketId The ticket ID to set.
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * Gets the type of the ticket.
	 *
	 * @return The ticket type.
	 */
	public TicketType getTicketType() {
		return ticketType;
	}
	/**
	 * Sets the type of the ticket.
	 *
	 * @param ticketType The ticket type to set.
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	/**
	 * Gets the status of the ticket.
	 *
	 * @return The ticket status.
	 */
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	/**
	 * Sets the status of the ticket.
	 *
	 * @param ticketStatus The ticket status to set.
	 */
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	/**
	 * Gets the title of the ticket.
	 *
	 * @return The ticket title.
	 */
	public String getTicketTitle() {
		return ticketTitle;
	}
	/**
	 * Sets the title of the ticket.
	 *
	 * @param ticketTitle The ticket title to set.
	 */
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	/**
	 * Gets the description of the ticket.
	 *
	 * @return The ticket description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Sets the description of the ticket.
	 *
	 * @param description The ticket description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the department associated with the ticket.
	 *
	 * @return The department.
	 */
	public DepartmentOutDto getDepartment() {
		return department;
	}
	/**
	 * Sets the department associated with the ticket.
	 *
	 * @param department The department to set.
	 */
	public void setDepartment(DepartmentOutDto department) {
		this.department = department;
	}
	/**
	 * Gets the user details associated with the ticket.
	 *
	 * @return The user details.
	 */
	public UserDetailsOutDto getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details associated with the ticket.
	 *
	 * @param userDetails The user details to set.
	 */
	public void setUserDetails(UserDetailsOutDto userDetails) {
		this.userDetails = userDetails;
	}
	/**
	 * Gets the list of comments associated with the ticket.
	 *
	 * @return The list of comments.
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * Sets the list of comments associated with the ticket.
	 *
	 * @param comments The list of comments to set.
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	/**
	 * Gets the date and time when the ticket was created.
	 *
	 * @return The creation date and time.
	 */
	public java.util.Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * Sets the date and time when the ticket was created.
	 *
	 * @param createdAt The creation date and time to set.
	 */
	public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * Gets the date and time when the ticket was last updated.
	 *
	 * @return The last update date and time.
	 */
	public java.util.Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * Sets the date and time when the ticket was last updated.
	 *
	 * @param updatedAt The last update date and time to set.
	 */
	public void setUpdatedAt(java.util.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "department=" + department + "]";
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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the deptId
	 */
	public long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	
	

}
