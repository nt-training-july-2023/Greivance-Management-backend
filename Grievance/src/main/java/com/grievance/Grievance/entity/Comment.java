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

@Entity
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long commentId;
	
	 private String content;
	 
	  @Column(name = "createdAt",nullable = false, updatable = false)
	  @CreationTimestamp
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date createdAt;
	  
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


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}