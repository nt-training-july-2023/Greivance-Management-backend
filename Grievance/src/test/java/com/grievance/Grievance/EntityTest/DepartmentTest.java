package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class DepartmentTest {

	@Test
	public void testDeptName() {
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());
		assertEquals("IT", department.getDeptName());
	}
	@Test
	public void testDeptId() {
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(1, department.getDeptId());
	}
	@Test
	public void testTickets() {
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(new ArrayList<Ticket>(), department.getTickets());
	}
	
	@Test
	public void testUsers() {
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(new ArrayList<UserDetails>(), department.getUserDetails());
	}
	
//	 @Test
//	    public void testToString() {
//	     
//	        Department department = new Department();
//	        department .setDeptId(1);
//	        department.setDeptName("HR");
//	        String toStringResult = department.toString();
//	        assertEquals("HR", toStringResult);
//	        assertEquals(1, toStringResult);
//	    }
}
