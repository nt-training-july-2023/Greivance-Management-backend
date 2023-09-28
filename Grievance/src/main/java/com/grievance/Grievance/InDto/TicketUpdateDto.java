package com.grievance.Grievance.InDto;

import com.grievance.Grievance.Enum.TicketStatus;
/**
 * Represents the input data for updating a ticket's status and content.
 */
public class TicketUpdateDto {
	/**
     * The updated status of the ticket.
     */
	private TicketStatus ticketStatus;
	/**
     * The updated content of the ticket.
     */
	private String content;


    /**
     * Gets the updated status of the ticket.
     *
     * @return The ticket status.
     */
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	  /**
     * Sets the updated status of the ticket.
     *
     * @param ticketStatus The ticket status.
     */
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}


    /**
     * Gets the updated content of the ticket.
     *
     * @return The ticket content.
     */
	public String getContent() {
		return content;
	}

	  /**
     * Sets the updated content of the ticket.
     *
     * @param content The ticket content.
     */
	public void setContent(String content) {
		this.content = content;
	}

	/**
     * 
     */
	@Override
	public String toString() {
		return "TicketUpdateDto [ticketStatus=" + ticketStatus + ", content=" + content + "]";
	}
}
