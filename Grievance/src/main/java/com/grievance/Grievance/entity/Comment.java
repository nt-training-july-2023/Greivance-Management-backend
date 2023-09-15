package com.grievance.Grievance.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long commentId;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Ticket ticket;
	
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "Id")
	private UserDetails userDetails;

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
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
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
	 * @param commentId
	 * @param content
	 * @param ticket
	 * @param userDetails
	 */
	public Comment(long commentId, String content, Ticket ticket, UserDetails userDetails) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.ticket = ticket;
		this.userDetails = userDetails;
	}

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}