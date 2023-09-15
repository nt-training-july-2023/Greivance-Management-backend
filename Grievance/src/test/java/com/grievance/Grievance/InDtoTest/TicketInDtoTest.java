package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;

public class TicketInDtoTest {

	@Test
	public void testTicketTitle() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
		assertEquals("Tech issue", ticketInDto.getTicketTitle());
		
	}
	
	@Test
	public void testTicketType() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
		assertEquals(TicketType.valueOf("GRIEVANCE"), ticketInDto.getTicketType());
		
	}
	
	@Test
	public void testComments() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
		assertEquals(new ArrayList<Comment>(), ticketInDto.getComments());
		
	}
	
	@Test
	public void testUser() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
	//	assertEquals(new UserDetails(), ticketInDto.getUserDetails());
		
	}
	
	@Test
	public void testDepartment() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("HR");
		ticketInDto.setDepartment(department);
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
	//	assertEquals(new Department(), ticketInDto.getDepartment());
	
	}
	@Test
	public void testDescription() {
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Tech issue");
		ticketInDto.setComments(new ArrayList<Comment>());
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticketInDto.setUserDetails(new UserDetails());
		assertEquals("abcd", ticketInDto.getDescription());
	}
	
	
}
