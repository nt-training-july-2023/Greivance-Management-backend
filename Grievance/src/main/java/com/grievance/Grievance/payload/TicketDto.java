package com.grievance.Grievance.payload;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.TicketStatus;
import com.grievance.Grievance.entity.TicketType;
import com.grievance.Grievance.entity.UserDetails;

public class TicketDto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long ticketId;

	@Enumerated(EnumType.STRING)
	private TicketType ticketType;

	@Enumerated(EnumType.STRING)
	private TicketStatus ticketStatus;

	@NotEmpty(message = "Title is required")
	private String ticketTitle;
	private String description;
	private Department department;
	private UserDetails userDetails;

	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updatedAt")
	private Date updatedAt;

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
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	 * @param ticketId
	 * @param ticketType
	 * @param ticketStatus
	 * @param ticketTitle
	 * @param description
	 * @param createdAt
	 * @param updatedAt
	 */
	public TicketDto(long ticketId, TicketType ticketType, TicketStatus ticketStatus, String ticketTitle,
			String description, Date createdAt, Date updatedAt) {
		super();
		this.ticketId = ticketId;
		this.ticketType = ticketType;
		this.ticketStatus = ticketStatus;
		this.ticketTitle = ticketTitle;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 */
	public TicketDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
