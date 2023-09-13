package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserType;

public class UserDetailsInDtoTest {

//	@BeforeEach
//	public void setUp() {
//		
//		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
//		userDetailsInDto.setDepartment(new Department());
//		userDetailsInDto.setEmail("sneha@nucleusteq.com");
//		userDetailsInDto.setName("Sneha");
//		userDetailsInDto.setPassword("Sneha@01");
//		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
//		
//	}

	@Test
	public void testEmail() {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		assertEquals("sneha@nucleusteq.com", userDetailsInDto.getEmail());
	}

	@Test
	public void testPassword() {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		assertEquals("Sneha@01", userDetailsInDto.getPassword());
	}

	@Test
	public void testUserType() {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		assertEquals(UserType.valueOf("MEMBER"), userDetailsInDto.getUserType());
	}

	@Test
	public void testName() {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		assertEquals("Sneha", userDetailsInDto.getName());
	}

	@Test
	public void testDepartment() {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		// assertEquals(new Department(), userDetailsInDto.getDepartment());
	}
}
