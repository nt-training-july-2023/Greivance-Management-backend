package com.grievance.Grievance.OutDto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents the output data for a comment.
 */
public class CommentOutDto {
	/**
	 * The unique identifier for the comment.
	 */
	private long commentId;

	/**
	 * The content of the comment.
	 */
	private String content;

	/**
	 * The last updated timestamp of the comment.
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date updatedAt;
	/**
	 * The ID of the ticket associated with this comment.
	 */
	private long ticketId;

	/**
	 * Gets the comment ID.
	 *
	 * @return The comment ID.
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment ID.
	 *
	 * @param commentId The comment ID.
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/**
	 * Gets the content of the comment.
	 *
	 * @return The content of the comment.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the comment.
	 *
	 * @param content The content of the comment.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the ID of the ticket associated with this comment.
	 *
	 * @return The ticket ID.
	 */
	public long getTicketId() {
		return ticketId;
	}

	/**
	 * Sets the ID of the ticket associated with this comment.
	 *
	 * @param ticketId The ticket ID.
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Gets the last updated timestamp of the comment.
	 *
	 * @return The last updated timestamp.
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the last updated timestamp of the comment.
	 *
	 * @param updatedAt The last updated timestamp.
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
