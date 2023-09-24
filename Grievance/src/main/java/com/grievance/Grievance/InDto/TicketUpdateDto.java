package com.grievance.Grievance.InDto;

import com.grievance.Grievance.Enum.TicketStatus;

public class TicketUpdateDto {

	private TicketStatus ticketStatus;
	private String content;

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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TicketUpdateDto [ticketStatus=" + ticketStatus + ", content=" + content + "]";
	}
}
