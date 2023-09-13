package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserType;

public class UserDetailsOutDtoTest {

	@Test
	public void testName() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals("Sneha" , userDetailsOutDto.getName());
		
	}
	@Test
	public void testId() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals(1 , userDetailsOutDto.getId());
	}
	
	@Test
	public void testEmail() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals("sneha@nucleusteq.com" , userDetailsOutDto.getEmail());
	}

	@Test
	public void testComments() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals(new ArrayList<Comment>() , userDetailsOutDto.getComments());
	}
	
	@Test
	public void testDepartment() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		//assertEquals(new Department(), userDetailsOutDto.getDepartment());
	}
	@Test
	public void testIsLoggedIn() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals(false, userDetailsOutDto.getIsLoggedIn());
	}
	
	@Test
	public void testTickets() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals(new ArrayList<Ticket>(), userDetailsOutDto.getTickets());
	}
	
	@Test
	public void testUserType() {
		  
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setName("Sneha");
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");
		userDetailsOutDto.setIsLoggedIn(false);
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		userDetailsOutDto.setUserType(UserType.valueOf("MEMBER"));
		assertEquals(UserType.valueOf("MEMBER"), userDetailsOutDto.getUserType());
	}
	
	
}
