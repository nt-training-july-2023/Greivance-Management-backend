package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.AuthenticationException;
import com.grievance.Grievance.exception.DuplicateEntryException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userservice;

  @Mock
  private DepartmentRepository departmentRepository;

  @Test
  public void testLoginUser_UserNotFound()
      throws AuthenticationException {
    LoginInDto loginInDto = new LoginInDto();
    loginInDto.setEmail("nonexistenceemail@nucleusteq.com");
    loginInDto.setPassword("correctPassword");
    when(userRepository
        .findByEmail("nonexistenceemail@nucleusteq.com"))
        .thenThrow(new AuthenticationException(""));
    assertThrows(AuthenticationException.class, () -> {
      userservice.userLogin(loginInDto);
    });
  }

  @Test
  public void testLoginUser_Success() {
    LoginInDto loginInDto = new LoginInDto();
    loginInDto.setEmail("user@example.com");
    loginInDto.setPassword("password123");

    UserDetails userDetails = new UserDetails();
    userDetails.setUserId(1L);
    userDetails.setEmail("user@example.com");
    userDetails.setPassword("password123");
    userDetails.setName("John Doe");
    userDetails.setIsLoggedIn(false);
    userDetails.setUsertype(UserType.Member);
    userDetails.setDepartment(new Department());

    when(userRepository.findByEmail("user@example.com"))
        .thenReturn(userDetails);
    UserDetailsOutDto userDetailsOutDto = userservice
        .userLogin(loginInDto);

    assertNotNull(userDetailsOutDto);
    assertEquals(1L, userDetailsOutDto.getId());
    assertFalse(userDetailsOutDto.getIsLoggedIn());
    assertEquals(UserType.Member, userDetailsOutDto.getUserType());
    assertEquals("user@example.com", userDetailsOutDto.getEmail());
    assertEquals("John Doe", userDetailsOutDto.getName());
    assertEquals(0L, userDetailsOutDto.getDeptId());

  }

  @Test
  public void testLoginUser_InvalidPassword()
      throws AuthenticationException {

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

    when(userRepository.findByEmail("sneha@nucleusteq.com"))
        .thenThrow(new AuthenticationException(""));
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
    userDetails.setIsLoggedIn(false);
    userDetails.setUsertype(UserType.Admin);

    Department department = new Department();

    UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
    userDetailsInDto.setEmail("sneha01@nucleusteq.com");
    userDetailsInDto.setDepartment(new Department());
    userDetailsInDto.setName("Sneha Bhate");
    userDetailsInDto.setPassword("correctPasswrod");
    userDetailsInDto.setUserType(UserType.Admin);
    userDetailsInDto.setDepartment(department);

    UserDetails userDetails2 = new UserDetails();
    userDetails2.setEmail("abcd@nucleusteq.com");

    when(userRepository.save(any(UserDetails.class)))
        .thenReturn(userDetails);
    UserDetailsOutDto userDetailsOutDto = userservice
        .createUser(userDetailsInDto);
    assertNotNull(userDetailsOutDto);

  }

  @Test
  public void testCreateUser_DuplicateEmail()
      throws DuplicateEntryException {
    UserDetailsInDto userDetailsInDto = new UserDetailsInDto();
    userDetailsInDto.setEmail("sameemail@nucleusteq.com");
    UserDetails userDetails = new UserDetails();
    userDetails.setEmail("sameemail@nucleusteq.com");
    when(userRepository.findByEmail("sameemail@nucleusteq.com"))
        .thenThrow(DuplicateEntryException.class);
    assertThrows(DuplicateEntryException.class, () -> {
      userservice.createUser(userDetailsInDto);
    });

  }

  @Test
  public void testChangePasswordSuccess() {
    ChangePasswordInDto changePasswordInDto = new ChangePasswordInDto();
    changePasswordInDto.setEmail("test@nucleusteq.com");
    changePasswordInDto.setOldPassword("oldPassword");
    changePasswordInDto.setNewPassword("newPassword");

    Department department = new Department();
    department.setDeptId(1);
    department.setDeptName("HR");

    UserDetails savedUserDetails = new UserDetails();
    savedUserDetails.setEmail(changePasswordInDto.getEmail());
    savedUserDetails
        .setPassword(changePasswordInDto.getOldPassword());
    savedUserDetails.setDepartment(department);
    savedUserDetails.setIsLoggedIn(true);
    savedUserDetails.setName("Sneha");
    savedUserDetails.setTickets(new ArrayList<Ticket>());
    savedUserDetails.setUserId(1);
    savedUserDetails.setUsertype(UserType.Member);

    when(userRepository.findByEmail(changePasswordInDto.getEmail()))
        .thenReturn(savedUserDetails);
    when(userRepository.save(savedUserDetails))
        .thenReturn(savedUserDetails);
    UserDetailsOutDto result = userservice
        .changePassword(changePasswordInDto);
    assertNotNull(result);
    assertEquals(changePasswordInDto.getNewPassword(),
        savedUserDetails.getPassword());
    assertEquals(true, savedUserDetails.getIsLoggedIn());
    assertEquals(changePasswordInDto.getEmail(),
        savedUserDetails.getEmail());
  }

  @Test
  public void testChangePasswordUserNotFound() {
    ChangePasswordInDto changePasswordInDto = new ChangePasswordInDto();
    changePasswordInDto.setEmail("nonexistent@example.com");
    changePasswordInDto.setOldPassword("oldPassword");
    changePasswordInDto.setNewPassword("newPassword");

    when(userRepository.findByEmail(changePasswordInDto.getEmail()))
        .thenReturn(null);

    assertThrows(AuthenticationException.class,
        () -> userservice.changePassword(changePasswordInDto));
  }

  @Test
  public void testChangePasswordIncorrectOldPassword() {
    ChangePasswordInDto changePasswordInDto = new ChangePasswordInDto();
    changePasswordInDto.setEmail("test@example.com");
    changePasswordInDto.setOldPassword("wrongPassword");
    changePasswordInDto.setNewPassword("newPassword");

    UserDetails savedUserDetails = new UserDetails();
    savedUserDetails.setEmail(changePasswordInDto.getEmail());
    savedUserDetails.setPassword("oldPassword");

    when(userRepository.findByEmail(changePasswordInDto.getEmail()))
        .thenReturn(savedUserDetails);

    assertThrows(AuthenticationException.class,
        () -> userservice.changePassword(changePasswordInDto));
  }

  @Test
  public void testGetAllUsers() {

    int pageNumber = 0;
    int pageSize = 10;

    PageRequest pageable = PageRequest.of(pageNumber, pageSize);

    UserDetails user1 = new UserDetails();
    user1.setName("sneha");
    user1.setDepartment(new Department());
    user1.setEmail("sneha@nucleusteq");
    user1.setIsLoggedIn(true);
    user1.setPassword("Sneha@01");
    user1.setTickets(new ArrayList<Ticket>());
    user1.setUserId(9);
    user1.setUsertype(UserType.Member);
    user1.setTickets(new ArrayList<Ticket>());

    UserDetails user2 = new UserDetails();
    user2.setName("palak");
    user2.setDepartment(new Department());
    user2.setEmail("palak@nucleusteq");
    user2.setIsLoggedIn(true);
    user2.setPassword("Palak@01");
    user2.setTickets(new ArrayList<Ticket>());
    user2.setUserId(9);
    user2.setUsertype(UserType.Member);
    user2.setTickets(new ArrayList<Ticket>());

    List<UserDetails> userList = Arrays.asList(user1, user2);
    Page<UserDetails> userPage = new PageImpl<>(userList, pageable,
        userList.size());

    List<UserDetails> userDetailsList = new ArrayList<>();
    userDetailsList.add(user1);
    userDetailsList.add(user2);

    UserDetailsOutDto userDetailsOutDto1 = new UserDetailsOutDto();
    userDetailsOutDto1.setName("sneha");
    userDetailsOutDto1
        .setDepartment(user1.getDepartment().getDeptName());
    userDetailsOutDto1.setEmail("sneha@nucleusteq");
    userDetailsOutDto1.setIsLoggedIn(true);
    userDetailsOutDto1.setPassword("Sneha@01");
    userDetailsOutDto1.setTickets(new ArrayList<TicketOutDto>());
    userDetailsOutDto1.setId(9);
    userDetailsOutDto1.setUserType(UserType.Member);
    userDetailsOutDto1.setTickets(new ArrayList<TicketOutDto>());
    userDetailsOutDto1.setDeptId(user1.getDepartment().getDeptId());

    UserDetailsOutDto userDetailsOutDto2 = new UserDetailsOutDto();
    userDetailsOutDto2.setName("palak");
    userDetailsOutDto2
        .setDepartment(user1.getDepartment().getDeptName());
    userDetailsOutDto2.setEmail("palak@nucleusteq");
    userDetailsOutDto2.setIsLoggedIn(true);
    userDetailsOutDto2.setPassword("Palak@01");
    userDetailsOutDto2.setTickets(new ArrayList<TicketOutDto>());
    userDetailsOutDto2.setId(9);
    userDetailsOutDto2.setUserType(UserType.Member);
    userDetailsOutDto2.setTickets(new ArrayList<TicketOutDto>());
    userDetailsOutDto2.setDeptId(user1.getDepartment().getDeptId());

    when(userRepository.findAll(pageable)).thenReturn(userPage);
    List<UserDetailsOutDto> userDetailsOutDtos = userservice
        .getAllUsers(pageNumber, pageSize);

    assertNotNull(userDetailsOutDtos);
    assertEquals(2, userDetailsOutDtos.size());
    verify(userRepository).findAll(pageable);
  }

  @Test
  public void testDeleteUser() {
    long userId = 1;
    UserDetails userDetails = new UserDetails();
    userDetails.setUserId(userId);
    when(userRepository.findById(userId))
        .thenReturn(Optional.of(userDetails));
    userservice.deleteUser(userId);
    verify(userRepository, Mockito.times(1)).deleteById(userId);
  }
}
