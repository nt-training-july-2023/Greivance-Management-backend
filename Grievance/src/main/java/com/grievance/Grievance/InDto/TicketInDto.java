package com.grievance.Grievance.InDto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;

/**
 * Represents the input data for creating or updating a ticket.
 */

public class TicketInDto {
	/**
	 * The type of the ticket (e.g., Grievance or Feedback).
	 */
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;

	/**
	 * The title of the ticket.
	 */
	@NotEmpty(message = "Title is required")
	private String ticketTitle;

	/**
	 * The description of the ticket.
	 */
	@NotEmpty(message = "Must add description")
	private String description;

	/**
	 * The status of the ticket (e.g., Open, Being_Addressed, Resolved).
	 */

	private TicketStatus ticketStatus;

	/**
	 * The department associated with the ticket.
	 */
	@NotNull
	private Department department;
	/**
	 * The user details of the ticket creator.
	 */
	@NotNull
	private UserDetails userDetails;
	/**
	 * The list of comments associated with the ticket.
	 */
	private List<Comment> comments;

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
	 * @param ticketType The ticket type.
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
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
	 * @param ticketTitle The ticket title.
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
	 * @param description The ticket description.
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @param department The department.
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Gets the user details of the ticket creator.
	 *
	 * @return The user details.
	 */
	public @NotNull UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details of the ticket creator.
	 *
	 * @param userDetails The user details.
	 */
	public void setUserDetails(@NotNull UserDetails userDetails) {
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
	 * @param comments The list of comments.
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	 * @param ticketStatus The ticket status.
	 */
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
}
