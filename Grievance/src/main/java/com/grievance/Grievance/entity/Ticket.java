package com.grievance.Grievance.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
/**
 * Represents a ticket in the system.
 */
@Entity
public class Ticket {
	/**
	 * The unique identifier for this ticket.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long ticketId;

	/**
	 * The title of the ticket.
	 */
	@NotEmpty
	private String ticketTitle;

	/**
	 * The description of the ticket.
	 */
	@NotEmpty
	private String description;
	/**
	 * The description of the ticket.
	 */
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;
	/**
	 * The status of the ticket.
	 */
	private TicketStatus ticketStatus;

	/**
	 * The date and time when the ticket was created.
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private java.util.Date createdAt;
	/**
	 * The date and time when the ticket was last updated.
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private java.util.Date updatedAt;
	/**
	 * The department to which the ticket is assigned.
	 */
	@JsonBackReference(value = "dep")
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department department;
	/**
	 * The user details associated with this ticket.
	 */
	@JsonBackReference(value = "user")
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userDetails;

	/**
	 * The list of comments associated with this ticket.
	 */
	@OneToMany(mappedBy = "ticket")
	private List<Comment> comments;

	/**
	 * Gets the unique identifier for this ticket.
	 *
	 * @return The ticket ID.
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
	 * Gets the department associated with the ticket.
	 *
	 * @return The department.
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets the department associated with the ticket.
	 *
	 * @param department The department to set.
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Gets the user details associated with the ticket.
	 *
	 * @return The user details.
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details associated with the ticket.
	 *
	 * @param userDetails The user details to set.
	 */
	public void setUserDetails(UserDetails userDetails) {
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
	public void setCreatedAt(Date createdAt) {
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

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Constructs a new Ticket object with the specified parameters.
	 *
	 * @param ticketId     The unique identifier for this ticket.
	 * @param ticketTitle  The title of the ticket.
	 * @param description  The description of the ticket.
	 * @param ticketType   The type of the ticket.
	 * @param ticketStatus The status of the ticket.
	 * @param createdAt    The date and time when the ticket was created.
	 * @param updatedAt    The date and time when the ticket was last updated.
	 * @param department   The department associated with the ticket.
	 * @param userDetails  The user details associated with the ticket.
	 * @param comments     The list of comments associated with the ticket.
	 */
	public Ticket(long ticketId, @NotEmpty String ticketTitle, @NotEmpty String description, TicketType ticketType,
			TicketStatus ticketStatus, java.util.Date createdAt, java.util.Date updatedAt, Department department,
			UserDetails userDetails, List<Comment> comments) {
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
	 * Create a new instance of the Ticket class.
	 */
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketTitle=" + ticketTitle + ", description=" + description
				+ ", ticketType=" + ticketType + ", ticketStatus=" + ticketStatus + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", department=" + department + ", userDetails=" + userDetails
				+ ", comments=" + comments + "]";
	}

}