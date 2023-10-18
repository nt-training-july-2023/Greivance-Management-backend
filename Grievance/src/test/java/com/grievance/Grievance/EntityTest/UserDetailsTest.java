package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class UserDetailsTest{
	
	
	 private UserDetails userDetails;
		
	 @BeforeEach
	 public void setUp() {
		    userDetails = new UserDetails();
			userDetails.setUserId(1);
			userDetails.setName("Sneha");
			userDetails.setPassword("Sneha@01");
			userDetails.setIsLoggedIn(false);
			userDetails.setUsertype(UserType.valueOf("Member"));
			userDetails.setDepartment(new Department());
			userDetails.setTickets(new ArrayList<Ticket>());
			userDetails.setEmail("sneha@nucleusteq.com");
	 }
	
	@Test
	public void testName() {
		
		
		assertEquals("Sneha",userDetails.getName());
	}
	@Test
	public void testEmail() {
		
		
		assertEquals("sneha@nucleusteq.com",userDetails.getEmail());
	}
	
	@Test
	public void testPassword() {
		
	
		assertEquals("Sneha@01",userDetails.getPassword());
	}
	@Test
	public void testDepartment() {
		
	
		assertNotEquals(new Department(),userDetails.getDepartment());
	}
	@Test
	public void testUserType() {
		
	
		assertEquals(UserType.valueOf("Member"),userDetails.getUsertype());
	}
	
	@Test
	public void testTicket() {
		
		assertEquals(new ArrayList<Ticket>(),userDetails.getTickets());
	}
	@Test
	public void testId() {
	
		assertEquals(1,userDetails.getUserId());
	}
	
	@Test
	public void testIsLoggedIn() {
		
		assertEquals(false,userDetails.getIsLoggedIn());
		
	}

	@Test
	public void testUserDetails() {
	UserDetails userDetails = new UserDetails(
            1L,
            "Sneha",
            "sneha@nucleusteq.com",
            "password",
            UserType.Admin,
            true,
            new Department(),
            null
    );
	
	assertNotNull(userDetails);
	assertEquals(1L, userDetails.getUserId());
    assertEquals("Sneha", userDetails.getName());
    assertEquals("sneha@nucleusteq.com", userDetails.getEmail());
    assertEquals("password", userDetails.getPassword());
    assertEquals(UserType.Admin, userDetails.getUsertype());
    assertTrue(userDetails.getIsLoggedIn());
    assertNotNull(userDetails.getDepartment());
	}
	
	  @Test
	    public void testToString() {
	    
	    Department department = new Department();
	    department.setDeptId(1);
	    department.setDeptName("IT");
	    department.setTickets(new ArrayList<Ticket>());
	    department.setUserDetails(new ArrayList<UserDetails>());
	        UserDetails userDetails = new UserDetails();
	        userDetails.setUserId(1L);
	        userDetails.setName("Sneha");
	        userDetails.setEmail("sneha@nucleusteq.com");
	        userDetails.setPassword("secret");
	        userDetails.setUsertype(UserType.Member);
	        userDetails.setIsLoggedIn(false);
	        userDetails.setDepartment(department);
	        String expectedString = "UserDetails [userId=1, name=Sneha, email=sneha@nucleusteq.com, password=secret, usertype=Member, isLoggedIn=false, department=deptId=1, deptName=IT, tickets=null]";
	        String actualString = userDetails.toString();

	        assertEquals(expectedString, actualString);
	    }
	
	
}