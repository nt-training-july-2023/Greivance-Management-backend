package com.grievance.Grievance.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.sym.Name;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;

@Entity
public class Ticket{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long ticketId;
	
	@NotEmpty
	private String ticketTitle;
	
	@NotEmpty
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;
	
	@Enumerated(EnumType.STRING)
	private TicketStatus ticketStatus;
	
	@CreationTimestamp
	@Column(name = "createdAt",nullable = false, updatable = false )
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private Date updatedAt;
	
	@JsonBackReference(value = "depar")
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department department;
	
	@JsonBackReference(value = "user")
	@ManyToOne
	@JoinColumn(name = "Id")
	private UserDetails userDetails;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
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
	public String getDecription() {
		return description;
	}

	/**
	 * @param decription the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @param ticketId
	 * @param ticketTitle
	 * @param decription
	 * @param ticketType
	 * @param ticketStatus
	 * @param createdAt
	 * @param updatedAt
	 * @param department
	 * @param userDetails
	 * @param comments
	 */
	public Ticket(long ticketId, @NotEmpty String ticketTitle, @NotEmpty String description, TicketType ticketType,
			TicketStatus ticketStatus, Date createdAt, Date updatedAt, Department department, UserDetails userDetails,
			List<Comment> comments) {
		super();
		this.ticketId = ticketId;
		this.ticketTitle = ticketTitle;
		this.description = description;
		this.ticketType = ticketType;
		this.ticketStatus = ticketStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.department = department;
		this.userDetails = userDetails;
		this.comments = comments;
	}

	/**
	 * 
	 */
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}