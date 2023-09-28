package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.AuthenticationException;
import com.grievance.Grievance.exception.DuplicateEntryException;
import com.grievance.Grievance.exception.RecordNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private ModelMapper modelMapper;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userservice;

	@Mock
	private DepartmentRepository departmentRepository;

	@Test
	public void testLoginUser_UserNotFound() throws AuthenticationException {
		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("nonexistenceemail@nucleusteq.com");
		loginInDto.setPassword("correctPassword");
		when(userRepository.findByEmail("nonexistenceemail@nucleusteq.com")).thenThrow(new AuthenticationException(""));
		assertThrows(AuthenticationException.class, () -> {
			userservice.userLogin(loginInDto);
		});
	}

	@Test
	public void testLoginUser_Success() {
		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("sneha@nucleusteq.com");
		loginInDto.setPassword("correctPassword");

		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("correctPassword");
		userDetails.setEmail(loginInDto.getEmail());
		userDetails.setIsLoggedIn(false);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha");
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setUserId(1);
		userDetails.setUsertype(UserType.Member);

		when(userRepository.findByEmail("sneha@nucleusteq.com")).thenReturn(userDetails);
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		userDetailsOutDto.setIsLoggedIn(true);
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertNotNull(userDetailsOutDto);
		assertTrue(userDetailsOutDto.getIsLoggedIn());
		assertEquals(userDetailsOutDto, userservice.userLogin(loginInDto));

	}

	@Test
	public void testLoginUser_InvalidPassword() throws AuthenticationException {

		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("Password");
		userDetails.setEmail("sneha@nucleusteq");
		userDetails.setIsLoggedIn(false);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha");
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setUserId(1);
		userDetails.setUsertype(UserType.Member);

		LoginInDto loginInDto = new LoginInDto();
		loginInDto.setEmail("sneha@nucleusteq.com");
		loginInDto.setPassword("incorrectPassword");

		when(userRepository.findByEmail("sneha@nucleusteq.com")).thenThrow(new AuthenticationException(""));
		assertThrows(AuthenticationException.class, () -> {
			userservice.userLogin(loginInDto);
		});
	}

	@Test
	public void testCreateUser_Success() {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail("sneha@nucleusteq.com");
		userDetails.setUserId(1);
		userDetails.setDepartment(new Department());
		userDetails.setName("Sneha Bhate");
		userDetails.setPassword("correctPasswrod");
		userDetails.setIsLoggedIn(true);
		userDetails.setUsertype(UserType.Admin);

		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setEmail("sneha@nucleusteq.com");
		userDetailsInDto.setDepartment(new Department());
		userDetailsInDto.setName("Sneha Bhate");
		userDetailsInDto.setPassword("correctPasswrod");
		userDetailsInDto.setUserType(UserType.Admin);

		UserDetails user = new UserDetails();
		user.setEmail("snehabhate@nucleusteq");

		when(modelMapper.map(userDetailsInDto, UserDetails.class)).thenReturn(userDetails);
		when(userRepository.findByEmail("sneha@nucleusteq.com")).thenReturn(user);
		when(userRepository.save(any(UserDetails.class))).thenReturn(userDetails);
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(modelMapper.map(userDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertNotNull(userDetailsOutDto);
		assertEquals(userDetailsOutDto, userservice.createUser(userDetailsInDto));
	}

	// when already email exist.

	@Test
	public void testCreateUser_DuplicateEmail() throws DuplicateEntryException {
		UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
		userDetailsInDto.setEmail("sameemail@nucleusteq.com");
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail("sameemail@nucleusteq.com");
		when(userRepository.findByEmail("sameemail@nucleusteq.com")).thenThrow(DuplicateEntryException.class);
		assertThrows(DuplicateEntryException.class, () -> {
			userservice.createUser(userDetailsInDto);
		});

	}

	@Test
	public void testChangePassword_Success() {

		ChangePasswordInDto changePasswordInDto = new ChangePasswordInDto();
		changePasswordInDto.setEmail("existing@nucleusteq.com");
		changePasswordInDto.setOldPassword("oldPassword");
		changePasswordInDto.setNewPassword("newPassword");

		UserDetails savedUserDetails = new UserDetails();
		savedUserDetails.setEmail("existing@nucleusteq.com");
		savedUserDetails.setPassword("oldPassword");

		when(userRepository.findByEmail("existing@nucleusteq.com")).thenReturn(savedUserDetails);
		UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(modelMapper.map(savedUserDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		UserDetailsOutDto userDetailsOutDto2 = userservice.changePassword(changePasswordInDto);

//	    UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
		when(modelMapper.map(savedUserDetails, UserDetailsOutDto.class)).thenReturn(userDetailsOutDto);
		assertEquals(userDetailsOutDto, userservice.changePassword(changePasswordInDto));
		assertEquals(userDetailsOutDto2, userRepository.save(savedUserDetails));

		assertNotNull(userDetailsOutDto2);
		assertEquals("newPassword", savedUserDetails.getPassword());
		verify(userRepository).save(savedUserDetails);
		assertTrue(savedUserDetails.getIsLoggedIn());
	}

    @Test
    public void testGetAllUsers() {
    	UserDetails user1 =  new UserDetails();
    	user1.setName("sneha");
    	user1.setDepartment(new Department());
    	user1.setEmail("sneha@nucleusteq");
    	user1.setIsLoggedIn(true);
    	user1.setPassword("Sneha@01");
    	user1.setTickets(new ArrayList<Ticket>());
    	user1.setUserId(9);
    	user1.setUsertype(UserType.Member);
    	
    	UserDetails user2 =  new UserDetails();
    	user2.setName("palak");
    	user2.setDepartment(new Department());
    	user2.setEmail("palak@nucleusteq");
    	user2.setIsLoggedIn(true);
    	user2.setPassword("Palak@01");
    	user2.setTickets(new ArrayList<Ticket>());
    	user2.setUserId(9);
    	user2.setUsertype(UserType.Member);
    	
        List<UserDetails> userDetailsList = new ArrayList<>();
        
        userDetailsList.add(user1);
        userDetailsList.add(user2);

        Page<UserDetails> userPage = new PageImpl<>(userDetailsList);

        when(userRepository.findAll(any(Pageable.class))).thenReturn(userPage);

        List<UserDetailsOutDto> userOutDtoList = userservice.getAllUsers(0, 10);

        assertEquals(2, userOutDtoList.size());
        verify(userRepository, times(1)).findAll();

       
    }
}
