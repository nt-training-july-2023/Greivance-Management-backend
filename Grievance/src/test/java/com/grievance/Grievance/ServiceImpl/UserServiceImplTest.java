package com.grievance.Grievance.ServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.entity.UserType;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private UserRepository userRepository;
	
	
	@InjectMocks
	private UserServiceImpl userserviceImpl;

	@Test
    public void testLoginUser_validInput_notLoggedIn() {
        LoginInDto loginInDto = new LoginInDto();
        loginInDto.setEmail("test@email.com");
        loginInDto.setPassword("correctPassword");
        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("correctPassword");
        userDetails.setIsLoggedIn(false);
        userDetails.setDepartment(new Department());
        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
        when(userRepository.findByEmail(loginInDto.getEmail())).thenReturn(userDetails);
        when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
        assertEquals(Optional.of(userDetailsOutDto),userserviceImpl.loginService(loginInDto));
    }
	@Test
    public void testLoginUser_validInput_LoggedIn() {
        LoginInDto loginInDto = new LoginInDto();
        loginInDto.setEmail("test@email.com");
        loginInDto.setPassword("correctPassword");
        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("correctPassword");
        userDetails.setIsLoggedIn(true);
        userDetails.setDepartment(new Department());
        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
        when(userRepository.findByEmail(loginInDto.getEmail())).thenReturn(userDetails);
        when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
        assertEquals(Optional.of(userDetailsOutDto),userserviceImpl.loginService(loginInDto));
       
    }
	
	@Test
	public void testLoginUser_InvalidInput_NotLoggedIn() {
		    LoginInDto loginInDto = new LoginInDto();
		    loginInDto.setEmail("test@email.com");
		    loginInDto.setPassword("incorrectPassword");
	        UserDetails userDetails = new UserDetails();
	        userDetails.setPassword("incorrectPassword");
	        userDetails.setIsLoggedIn(false);
	        userDetails.setDepartment(new Department());   
	        when(userRepository.findByEmail(loginInDto.getEmail())).thenReturn(null); 
	        assertEquals(Optional.empty(),userserviceImpl.loginService(loginInDto));
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
        when(modelMapper.map(userDetailsInDto,UserDetails.class)).thenReturn(userDetails);
        when(userRepository.save(userDetails)).thenReturn(userDetails);
        when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
        assertEquals(Optional.of(userDetailsOutDto), userserviceImpl.createUser(userDetailsInDto));
	}
	
	// when already email exist.
	
	@Test
	 public void testCreateUser_InvalidInput_Returns_Null(){
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail("emailalreadyexist@nucleusteq.com");
		userDetails.setId(1);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha Bhate");
		userDetails.setPassword("correctPasswrod");
		userDetails.setIsLoggedIn(true);
		userDetails.setUserType(UserType.valueOf("MEMBER"));
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
        when(modelMapper.map(userDetailsInDto,UserDetails.class)).thenReturn(userDetails);
        when(userRepository.save(userDetails)).thenReturn(userDetails);
        when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
        assertEquals(Optional.empty(), userserviceImpl.createUser(null));
	
	}
	
	
	}