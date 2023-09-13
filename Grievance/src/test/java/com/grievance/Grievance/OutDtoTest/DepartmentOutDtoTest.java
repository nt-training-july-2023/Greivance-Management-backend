package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class DepartmentOutDtoTest {

	@Test
	public void testDeptName() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		departmentOutDto.setTickets(new ArrayList<Ticket>());
		departmentOutDto.setUserDetails(new ArrayList<UserDetails>());
		assertEquals("IT",departmentOutDto.getDeptName());
	}
	
	@Test
	public void testDeptId() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		departmentOutDto.setTickets(new ArrayList<Ticket>());
		departmentOutDto.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(1, departmentOutDto.getDeptId());
	}
	@Test
	public void testDeptTickets() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		departmentOutDto.setTickets(new ArrayList<Ticket>());
		departmentOutDto.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(new ArrayList<Ticket>(), departmentOutDto.getTickets());
	}
	
	@Test
	public void testDeptUser() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		departmentOutDto.setTickets(new ArrayList<Ticket>());
		departmentOutDto.setUserDetails(new ArrayList<UserDetails>());
		assertEquals(new ArrayList<UserDetails>(), departmentOutDto.getUserDetails());
	}
	
}
