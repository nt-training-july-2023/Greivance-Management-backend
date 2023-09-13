package com.grievance.Grievance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {

	@Id
	private long comment_Id;
	
	@NotNull
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name = "ticketId")
	@JsonBackReference
	private Ticket ticket;
	
}
