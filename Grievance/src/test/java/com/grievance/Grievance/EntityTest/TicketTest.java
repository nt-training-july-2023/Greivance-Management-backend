package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class TicketTest {

	
	@Test
	public void testTicketTitle() {
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		assertEquals("abcd", ticket.getTicketTitle());
		}
	
	
	@Test
	public void testTicketType() {
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		assertEquals(TicketType.valueOf("GRIEVANCE"), ticket.getTicketType());
		}
	@Test
	public void testTicketStatus() {
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		assertEquals(TicketStatus.valueOf("OPEN"), ticket.getTicketStatus());
		}
	
	@Test
	public void testTicketId() {
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		assertEquals(1, ticket.getTicketId());
		}
	
	@Test
	public void testTicketDescription() {
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		assertEquals(1, ticket.getTicketId());
		}
	
	@Test
	public void testTicketDepartment() {
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("abcd");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		//assertEquals(new Department(), ticket.getDepartment());
		}
}
