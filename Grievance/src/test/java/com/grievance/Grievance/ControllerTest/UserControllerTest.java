package com.grievance.Grievance.ControllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.controller.UserController;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserType;
import com.grievance.Grievance.payload.LoginDto;
import com.grievance.Grievance.service.UserService;

import ch.qos.logback.core.util.ContentTypeUtil;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {


	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	@Autowired
	MockMvc mockMvc;

	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		objectMapper = new ObjectMapper();
		
	}

	@Test
	public void testLoginMember() throws Exception {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail("testtesttest@nucleusteq.com");
		loginDto.setPassword("Test@123");
		UserDetailsOutDto userDetailsOutDtoExpected = new UserDetailsOutDto();
		userDetailsOutDtoExpected.setName("Test3");
		userDetailsOutDtoExpected.setIsLoggedIn(false);
		userDetailsOutDtoExpected.setEmail("testtesttest@nucleusteq.com");
		userDetailsOutDtoExpected.setUserType(UserType.valueOf("MEMBER"));
		userDetailsOutDtoExpected.setDepartment(new Department());
		userDetailsOutDtoExpected.setTickets(new ArrayList<Ticket>());

		when(userService.loginService(Mockito.any(LoginInDto.class))).thenReturn(Optional.of(userDetailsOutDtoExpected));

		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/login").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(loginDto)).header("email", "ayushi@nucleusteq.com")
				.header("password", "Ayushi#123")).andExpect(status().isAccepted())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateUser_Return_UserObject() throws Exception{
		
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha Bhate");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("MEMBER"));
		
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setComments(new ArrayList<Comment>());
		userDetailsOutDto.setDepartment(new Department());
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setIsLoggedIn(true);
		userDetailsOutDto.setName("Sneha Bhate");
		userDetailsOutDto.setTickets(new ArrayList<Ticket>());
		
		when(userService.createUser(Mockito.any(UserDetailsInDto.class))).thenReturn(Optional.of(userDetailsOutDto));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/saveUser").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(userDetailsInDto)).header("email", "sneha@nucleusteq.com")
				.header("password", "Sneha@01")).andExpect(status().isCreated())
				.andDo(MockMvcResultHandlers.print());
		
	}
	
}
