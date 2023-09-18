package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;

public class TicketInDtoTest {

	private TicketInDto ticketInDto;
	@BeforeEach
	public void setUp() {
		
	    ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		
		Department department = new Department();
		ticketInDto.setDepartment(department);
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.Grievance);
		
		UserDetails userDetails = new UserDetails();
		ticketInDto.setUserDetails(userDetails);
		
		assertEquals("Tech issue", ticketInDto.getTicketTitle());
	}
	
	

	@Test
	public void testTicketTitle() {
	
		assertEquals("Tech issue", ticketInDto.getTicketTitle());
		
	}
	
	@Test
	public void testTicketType() {
		
		assertEquals(TicketType.Grievance, ticketInDto.getTicketType());
		
	}
	
	
	
	@Test
	public void testUser() {
	
		assertNotNull(ticketInDto.getUserDetails());
		
	}
	
	@Test
	public void testDepartment() {
		
		assertNotNull(ticketInDto.getDepartment());
	
	}
	@Test
	public void testDescription() {
	
		assertEquals("abcd", ticketInDto.getDescription());
	}
	
	
}
