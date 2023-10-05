package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class TicketTest {

	@Test
	public void testTicketConstructorAndGetters() {
		Department department = new Department();
		department.setDeptId(1L);
		department.setDeptName("Department1");

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(2L);
		userDetails.setName("Sneha");

		Comment comment = new Comment();
		comment.setCommentId(3L);
		comment.setContent("Department2");

		List<Comment> comments = new ArrayList<>();
		comments.add(comment);

		Ticket ticket = new Ticket(1L, "Title", "Description", TicketType.Grievance, TicketStatus.Open, new Date(),
				new Date(), department, userDetails, comments);

		assertEquals(1L, ticket.getTicketId());
		assertEquals("Title", ticket.getTicketTitle());
		assertEquals("Description", ticket.getDescription());
		assertEquals(TicketType.Grievance, ticket.getTicketType());
		assertEquals(TicketStatus.Open, ticket.getTicketStatus());
		assertEquals(new Date(), ticket.getCreatedAt());
		assertEquals(new Date(), ticket.getUpdatedAt());
		assertEquals(department, ticket.getDepartment());
		assertEquals(userDetails, ticket.getUserDetails());
		assertEquals(comments, ticket.getComments());
	}

	@Test
	public void testTicketSetters() {
		Ticket ticket = new Ticket();

		Department department = new Department();
		UserDetails userDetails = new UserDetails();
		List<Comment> comments = new ArrayList<>();

		ticket.setTicketId(1L);
		ticket.setTicketTitle("Title");
		ticket.setDescription("Description");
		ticket.setTicketType(TicketType.Feedback);
		ticket.setTicketStatus(TicketStatus.Resolved);
		ticket.setDepartment(department);
		ticket.setUserDetails(userDetails);
		ticket.setComments(comments);

		assertEquals(1L, ticket.getTicketId());
		assertEquals("Title", ticket.getTicketTitle());
		assertEquals("Description", ticket.getDescription());
		assertEquals(TicketType.Feedback, ticket.getTicketType());
		assertEquals(TicketStatus.Resolved, ticket.getTicketStatus());
		assertEquals(department, ticket.getDepartment());
		assertEquals(userDetails, ticket.getUserDetails());
		assertEquals(comments, ticket.getComments());
	}
	}


