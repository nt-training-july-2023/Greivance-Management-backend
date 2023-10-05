package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.InDto.CommentInDto;
import com.grievance.Grievance.entity.Ticket;

public class CommentInDtoTest {

	private CommentInDto comment;

	@BeforeEach
	public void setUp() {
		comment = new CommentInDto();
	}

	@Test
	public void testCommentId() {
		comment.setCommentId(1);
		assertEquals(Integer.valueOf(1), comment.getCommentId());
	}

	@Test
	public void testContent() {
		comment.setContent("comment");
		assertEquals("comment", comment.getContent());
	}

	@Test
	public void testCreatedAt() {
		Date createdAt = new Date(System.currentTimeMillis());
		comment.setCreatedAt(createdAt);
		assertEquals(createdAt, comment.getCreatedAt());
	}

	@Test
	public void testName() {
		comment.setName("John Doe");
		assertEquals("John Doe", comment.getName());
	}

	@Test
	public void testTicket() {
		Ticket ticket = new Ticket();
		comment.setTicket(ticket);
		assertNotNull(comment.getTicket());
	}

}
