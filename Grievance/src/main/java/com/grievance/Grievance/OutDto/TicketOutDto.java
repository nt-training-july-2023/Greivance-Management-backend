package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Comment;

public class TicketOutDto {

	private long ticketId;

	private TicketType ticketType;

	private TicketStatus ticketStatus;

	private String ticketTitle;

	private String description;

	private java.util.Date createdAt;

	private java.util.Date updatedAt;

	@JsonBackReference(value = "dep")
	private DepartmentOutDto department;

	@JsonBackReference(value = "user")
	private UserDetailsOutDto userDetails;

	private List<Comment> comments;

	/**
	 * @return the ticketId
	 */
	public long getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

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
	 * @return the ticketStatus
	 */
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
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
	public DepartmentOutDto getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(DepartmentOutDto department) {
		this.department = department;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetailsOutDto getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetailsOutDto userDetails) {
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
	 * @return the createdAt
	 */
	public java.util.Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public java.util.Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(java.util.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

//	/**
//	 * @param ticketId
//	 * @param ticketType
//	 * @param ticketStatus
//	 * @param ticketTitle
//	 * @param description
//	 * @param createdAt
//	 * @param updatedAt
//	 * @param department
//	 * @param userDetails
//	 * @param comments
//	 */
//	public TicketOutDto(long ticketId, TicketType ticketType, TicketStatus ticketStatus, String ticketTitle,
//			String description, java.util.Date createdAt, java.util.Date updatedAt, DepartmentOutDto department,
//			UserDetailsOutDto userDetails, List<Comment> comments) {
//		super();
//		this.ticketId = ticketId;
//		this.ticketType = ticketType;
//		this.ticketStatus = ticketStatus;
//		this.ticketTitle = ticketTitle;
//		this.description = description;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.department = department;
//		this.userDetails = userDetails;
//		this.comments = comments;
//	}

	@Override
	public String toString() {
		return "department=" + department + "]";
	}

}
