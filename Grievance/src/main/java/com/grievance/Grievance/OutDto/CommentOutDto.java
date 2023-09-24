package com.grievance.Grievance.OutDto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentOutDto {
	private long commentId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date updatedAt;

	private long ticketId;

	/**
	 * @return the commentId
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

}
