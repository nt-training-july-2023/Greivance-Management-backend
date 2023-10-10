package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class TicketTest {

	
	private Ticket ticket;

	@BeforeEach
	public void setUp() {
		
			
		    ticket = new Ticket();
			ticket.setDepartment(new Department());
			ticket.setDescription("abcd");
			ticket.setTicketId(1);
			ticket.setTicketStatus(TicketStatus.valueOf("Open"));
			ticket.setTicketTitle("abcd");
			ticket.setTicketType(TicketType.valueOf("Grievance"));
			ticket.setUserDetails(new UserDetails());
			
			}
	
	
	
	@Test
	public void testTicketTitle() {
		
		
		assertEquals("abcd", ticket.getTicketTitle());
		}
	
	
	@Test
	public void testTicketType() {
		
		assertEquals(TicketType.valueOf("Grievance"), ticket.getTicketType());
		}
	@Test
	public void testTicketStatus() {
		
		assertEquals(TicketStatus.valueOf("Open"), ticket.getTicketStatus());
		}
	
	@Test
	public void testTicketId() {
		
		
		assertEquals(1, ticket.getTicketId());
		}
	
	@Test
	public void testTicketDescription() {
		
		assertEquals(1, ticket.getTicketId());
		}
	
	@Test
	public void testTicketDepartment() {
		
		assertNotNull(ticket.getDepartment());
		}
	
	@Test 
	public void testUser() {
		assertNotNull(ticket.getUserDetails());
	}
}
