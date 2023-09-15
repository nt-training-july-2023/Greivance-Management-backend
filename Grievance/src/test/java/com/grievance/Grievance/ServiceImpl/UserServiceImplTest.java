package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.ResourceNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private ModelMapper modelMapper;

	@Mock
	private UserRepository userRepo;

	@InjectMocks
	private UserServiceImpl userservice;
	
	@Mock
	private DepartmentRepository departmentRepository;

	@Test
	public void testLoginUser_validInput_notLoggedIn() throws ResourceNotFoundException {
		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("sneha@nucleusteq.com");
		loginInDto.setPassword("correctPassword");
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("correctPassword");
		userDetails.setIsLoggedIn(false);
		userDetails.setEmail(loginInDto.getEmail());
		userDetails.setDepartment(new Department());
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(userRepo.findByEmail(loginInDto.getEmail())).thenReturn(userDetails);
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertEquals(Optional.of(userDetailsOutDto), userservice.loginService(loginInDto));
	}

	@Test
	public void testLoginUser_validInput_LoggedIn() {
		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("sneha@nucleusteq.com");
		loginInDto.setPassword("correctPassword");
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("correctPassword");
		userDetails.setEmail(loginInDto.getEmail());
		userDetails.setIsLoggedIn(true);
		userDetails.setDepartment(new Department());
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(userRepo.findByEmail(loginInDto.getEmail())).thenReturn(userDetails);
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertEquals(Optional.of(userDetailsOutDto), userservice.loginService(loginInDto));

	}

	@Test
	public void testLoginUser_InvalidInput_NotLoggedIn() throws RuntimeException{
		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("sneha@nucleusteq.com");
		loginInDto.setPassword("incorrectPassword");
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("incorrectPassword");
		userDetails.setEmail(loginInDto.getEmail());
		userDetails.setIsLoggedIn(false);
		userDetails.setDepartment(new Department());
		when(userRepo.findByEmail(loginInDto.getEmail())).thenThrow(new ResourceNotFoundException("", "", ""));
//		assertEquals(Optional.empty(), userservice.loginService(loginInDto));
		assertThrows(ResourceNotFoundException.class, ()->{
			userservice.loginService(loginInDto);
		});
	}

	// when email does not exist email

	@Test
	public void testCreateUser_ValidInput_Returns_UserObject() {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail("sneha@nucleusteq.com");
		userDetails.setId(1);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha Bhate");
		userDetails.setPassword("correctPasswrod");
		userDetails.setIsLoggedIn(true);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(modelMapper.map(userDetailsInDto, UserDetails.class)).thenReturn(userDetails);
		when(userRepo.save(userDetails)).thenReturn(userDetails);
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertEquals(Optional.of(userDetailsOutDto), userservice.createUser(userDetailsInDto));
	}

	// when already email exist.

	@Test
	public void testCreateUser_InvalidInput_Returns_Null() {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail("emailalreadyexist@nucleusteq.com");
		userDetails.setId(1);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha Bhate");
		userDetails.setPassword("correctPasswrod");
		userDetails.setIsLoggedIn(true);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		userDetails.setTickets(new ArrayList<Ticket>());
	    UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
	    when(modelMapper.map(userDetailsInDto, UserDetails.class)).thenReturn(userDetails);
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(modelMapper.map(userDetails , UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		when(userRepo.save(userDetails)).thenReturn(userDetails);
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertEquals(Optional.ofNullable(userDetailsOutDto), userservice.createUser(userDetailsInDto));
	}
}