package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.entity.UserType;

public class UserDetailsTest{
	
	
	@Test
	public void testName() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals("Sneha",userDetails.getName());
	}
	@Test
	public void testEmail() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals("sneha@nucleusteq.com",userDetails.getEmail());
	}
	
	@Test
	public void testPassword() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals("Sneha@01",userDetails.getPassword());
	}
	@Test
	public void testDepartment() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
	//	assertEquals(new Department(),userDetails.getDepartment());
	}
	@Test
	public void testUserType() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals(UserType.valueOf("MEMBER"),userDetails.getUserType());
	}
	
	@Test
	public void testTicket() {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals(new ArrayList<Ticket>(),userDetails.getTickets());
	}
	@Test
	public void testId() {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals(1,userDetails.getId());
	}
	
	@Test
	public void testIsLoggedIn() {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Sneha");
		userDetails.setPassword("Sneha@01");
		userDetails.setIsLoggedIn(false);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setComments(new ArrayList<Comment>());
		userDetails.setDepartment(new Department());
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setEmail("sneha@nucleusteq.com");
		assertEquals(false,userDetails.getIsLoggedIn());
		
	}

	
}