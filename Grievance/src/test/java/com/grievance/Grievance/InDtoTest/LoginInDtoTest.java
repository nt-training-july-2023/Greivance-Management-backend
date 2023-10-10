package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.InDto.LoginInDto;

public class LoginInDtoTest {

	private LoginInDto loginInDto;

	@BeforeEach
	void setUp() {

		loginInDto = new LoginInDto();

	}

	@Test
	void testEmail() {
		loginInDto.setEmail("sneha@nucleusteq.com");
		assertEquals("sneha@nucleusteq.com", loginInDto.getEmail());
	}

	@Test
	void testPassword() {
		loginInDto.setPassword("Password");
		assertEquals("Password", loginInDto.getPassword());
	}
}
