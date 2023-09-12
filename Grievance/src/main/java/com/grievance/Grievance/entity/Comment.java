package com.grievance.Grievance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {

	@Id
	private long comment_Id;
	
	@NotNull
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Ticket ticket;
	
}
