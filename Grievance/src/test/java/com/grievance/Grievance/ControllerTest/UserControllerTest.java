package com.grievance.Grievance.ControllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.CommentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.controller.UserController;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.service.UserService;

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
		LoginInDto loginDto = new LoginInDto();
		loginDto.setEmail("testtesttest@nucleusteq.com");
		loginDto.setPassword("Test@123");

		UserDetailsOutDto userDetailsOutDtoExpected = new UserDetailsOutDto();
		userDetailsOutDtoExpected.setName("Test3");
		userDetailsOutDtoExpected.setIsLoggedIn(false);
		userDetailsOutDtoExpected.setEmail("testtesttest@nucleusteq.com");
		userDetailsOutDtoExpected.setUserType(UserType.valueOf("Member"));
		userDetailsOutDtoExpected.setDepartment("IT");
		userDetailsOutDtoExpected.setTickets(new ArrayList<TicketOutDto>());

		when(userService.userLogin(Mockito.any(LoginInDto.class))).thenReturn(userDetailsOutDtoExpected);

		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/login").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(loginDto)).header("email", "ayushi@nucleusteq.com")
				.header("password", "Ayushi#123")).andExpect(status().isAccepted())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testCreateUser_Return_UserObject() throws Exception {

		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setName("Sneha Bhate");
		userDetailsInDto.setPassword("Sneha@01");
		userDetailsInDto.setUserType(UserType.valueOf("Member"));

		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setComments(new ArrayList<CommentOutDto>());
		userDetailsOutDto.setDepartment("IT");
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setIsLoggedIn(true);
		userDetailsOutDto.setName("Sneha Bhate");
		userDetailsOutDto.setTickets(new ArrayList<TicketOutDto>());

		when(userService.createUser(Mockito.any(UserDetailsInDto.class))).thenReturn(userDetailsOutDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(userDetailsInDto)).header("password", "Sneha@01"))
				.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void testGetAllUsers() throws Exception {
		Integer pageNumber = 0;
		Integer pageSize = 10;

		List<UserDetailsOutDto> userDetailsOutDtos = new ArrayList<>();
		userDetailsOutDtos.add(createSampleUserDetailsOutDto(1L, "user1@example.com"));
		userDetailsOutDtos.add(createSampleUserDetailsOutDto(2L, "user2@example.com"));

		Mockito.when(userService.getAllUsers(pageNumber, pageSize)).thenReturn(userDetailsOutDtos);

		mockMvc.perform(MockMvcRequestBuilders.get("/grievance/users").param("pageNumber", String.valueOf(pageNumber))
				.param("pageSize", String.valueOf(pageSize)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L));
		Mockito.verify(userService, Mockito.times(1)).getAllUsers(pageNumber, pageSize);
	}

	private UserDetailsOutDto createSampleUserDetailsOutDto(Long id, String email) {
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(id);
		userDetailsOutDto.setEmail(email);
		return userDetailsOutDto;
	}

	@Test
	public void testDeleteUser() throws Exception {
		Long userId = 1L;

		mockMvc.perform(MockMvcRequestBuilders.delete("/grievance/user/{userId}", userId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
	}

	@Test
	public void testChangePassword() throws Exception {
		ChangePasswordInDto changePasswordInDto = new ChangePasswordInDto();
		changePasswordInDto.setOldPassword("oldPassword");
		changePasswordInDto.setNewPassword("newPassword");
		changePasswordInDto.setEmail("sneha@nucleusteq.com");

		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setId(1);
		userDetailsOutDto.setEmail("sneha@nucleusteq.com");

		Mockito.when(userService.changePassword(Mockito.any(ChangePasswordInDto.class))).thenReturn(userDetailsOutDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/changepassword").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(changePasswordInDto)))
				.andExpect(MockMvcResultMatchers.status().isAccepted())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

		Mockito.verify(userService, Mockito.times(1)).changePassword(Mockito.any(ChangePasswordInDto.class));
	}

}
