package com.grievance.Grievance.InDto;

import java.sql.Date;

import com.grievance.Grievance.entity.Ticket;

public class CommentInDto {

	 private Integer commentId;

	  /**
	   * content.
	   */
	  private String content;

	  /**
	   * Creation time.
	   */
	  private Date createdAt;

	  /**
	   * employee name.
	   */
	  private String name;

	  /**
	   * ticket.
	   */
	  private Ticket ticket;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public CommentInDto() {
		super();
	}


}
