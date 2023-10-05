package com.grievance.Grievance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a comment related to a ticket.
 */
@Entity
public class Comment {

	/**
	 * The unique identifier for this comment.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long commentId;

	/**
	 * The content of the comment.
	 */
	private String content;

	/**
	 * The date and time when this comment was last updated.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedAt;

	/**
	 *  name of Member commented.
	 */
	private String memberName;

	/**
	 * Many-to-one relationship mapping to associate this entity with a UserDetails entity.
	 * This field represents the user details associated with this entity.
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private UserDetails userDetails;

	/**
	 * The ticket to which this comment is associated.
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ticketId")
	private Ticket ticket;

	/**
	 * Get the unique identifier for this comment.
	 *
	 * @return The comment's identifier.
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * Set the unique identifier for this comment.
	 *
	 * @param commentId The comment's identifier.
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/**
	 * Get the content of the comment.
	 *
	 * @return The comment's content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set the content of the comment.
	 *
	 * @param content The comment's content.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Get the ticket to which this comment is associated.
	 *
	 * @return The associated ticket.
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Set the ticket to which this comment is associated.
	 *
	 * @param ticket The associated ticket.
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Get the date and time when this comment was last updated.
	 *
	 * @return The last update date and time.
	 */
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	/**
	 * Set the date and time when this comment was last updated.
	 *
	 * @param lastUpdatedAt The last update date and time.
	 */
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	/**
	 * Create a new instance of the Comment class.
	 */
	public Comment() {
		super();
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @param commentId
	 * @param content
	 * @param lastUpdatedAt
	 * @param memberName
	 * @param ticket
	 */
	public Comment(long commentId, String content, Date lastUpdatedAt, String memberName, Ticket ticket) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.lastUpdatedAt = lastUpdatedAt;
		this.memberName = memberName;
		this.ticket = ticket;
	}
}