package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.TicketStatus;
import com.grievance.Grievance.entity.TicketType;
import com.grievance.Grievance.entity.UserDetails;

public class TicketOutDtoTest {

	@Test
	public void testTicketTitle() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		assertEquals("Tech issue", ticketOutDto.getTicketTitle());
	}

	@Test
	public void testTicketType() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		assertEquals(TicketType.valueOf("GRIEVANCE"), ticketOutDto.getTicketType());
	}

	@Test
	public void testTicketStatus() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		assertEquals(TicketStatus.valueOf("OPEN"), ticketOutDto.getTicketStatus());
	}

	@Test
	public void testTicketDescription() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		assertEquals("abcd", ticketOutDto.getDescription());
	}

	@Test
	public void testTicketDepartment() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		// assertEquals(new Department(), ticketOutDto.getDepartment());
	}

	@Test
	public void testTicketCommets() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		assertEquals(new ArrayList<Comment>(), ticketOutDto.getComments());
	}

	@Test
	public void testUsers() {

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new Department());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketOutDto.setUserDetails(new UserDetails());
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("OPEN"));
		// assertEquals(new UserDetails(), ticketOutDto.getUserDetails());
	}

}
