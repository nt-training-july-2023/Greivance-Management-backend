package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.entity.Department;

public class UserDetailsInDtoTest {

	private UserDetailsInDto userDetailsInDto;

	@BeforeEach
	public void setUp() {

		userDetailsInDto = new UserDetailsInDto();
		
		Department department = new Department();
		userDetailsInDto.setDepartment(department);
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("Member"));

	}

	@Test
	public void testEmail() {

		assertEquals("sneha@nucleusteq.com", userDetailsInDto.getEmail());
	}

	@Test
	public void testPassword() {

		assertEquals("Sneha@01", userDetailsInDto.getPassword());
	}

	@Test
	public void testUserType() {

		assertEquals(UserType.valueOf("Member"), userDetailsInDto.getUserType());
	}

	@Test
	public void testName() {

		assertEquals("Sneha", userDetailsInDto.getName());
	}

	@Test
	public void testDepartment() {

		assertNotNull(userDetailsInDto.getDepartment());
	}
}
