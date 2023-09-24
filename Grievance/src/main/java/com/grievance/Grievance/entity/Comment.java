package com.grievance.Grievance.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long commentId;

	private String content;

	@Column(name = "createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedAt;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Ticket ticket;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the lastUpdatedAt
	 */
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	/**
	 * @param lastUpdatedAt the lastUpdatedAt to set
	 */
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	/**
	 * @param commentId
	 * @param content
	 * @param lastUpdatedAt
	 * @param ticket
	 */
	public Comment(long commentId, String content, Date lastUpdatedAt, Ticket ticket) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.lastUpdatedAt = lastUpdatedAt;
		this.ticket = ticket;
	}

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}