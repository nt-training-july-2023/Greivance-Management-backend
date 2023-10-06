package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.Constants.ValidationErrors;
import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.AuthenticationException;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.UserService;

/**
 * Implementation of the UserService interface providing operations related to
 * users.
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * Logger initialization.
   */
  private static final Logger LOGGER = LogManager
      .getLogger(UserServiceImpl.class);

  /**
   * Auto wired UserRepository.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Creates a new user based on the provided UserDetailsInDto.
   *
   * @param userDetailsInDto The DTO containing user details.
   * @return The DTO representing the created user.
   */
  @Override
  public UserDetailsOutDto createUser(
      UserDetailsInDto userDetailsInDto) {
    UserDetails userDetails = new UserDetails();
    userDetails.setDepartment(userDetailsInDto.getDepartment());
    userDetails.setEmail(userDetailsInDto.getEmail());
    userDetails.setName(userDetailsInDto.getName());
    userDetails.setPassword(userDetailsInDto.getPassword());
    userDetails.setUsertype(userDetailsInDto.getUserType());
    UserDetails userDetails2 = userRepository
        .findByEmail(userDetailsInDto.getEmail());
    if (Objects.nonNull(userDetails2)) {
      LOGGER.error("Email Already Exist");
      throw new DuplicateKeyException(
          ValidationErrors.USER_NAME_ERROR);
    }
    UserDetails savedUser = userRepository.save(userDetails);
    UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
    userDetailsOutDto.setName(savedUser.getName());
    userDetailsOutDto.setId(savedUser.getUserId());
    userDetailsOutDto
        .setDeptId(savedUser.getDepartment().getDeptId());
    userDetailsOutDto.setEmail(savedUser.getEmail());
    userDetailsOutDto.setUserType(savedUser.getUsertype());
    userDetailsOutDto.setIsLoggedIn(savedUser.getIsLoggedIn());
    userDetailsOutDto.setPassword(savedUser.getPassword());
    return userDetailsOutDto;
  }

  /**
   * Performs user authentication based on the provided LoginInDto.
   *
   * @param loginInDto The DTO containing login information.
   * @return The DTO representing the authenticated user.
   * @throws AuthenticationException If authentication fails.
   */
  @Override
  public UserDetailsOutDto userLogin(LoginInDto loginInDto) {

    String email = loginInDto.getEmail();
    String password = loginInDto.getPassword();
    UserDetails userDetailsSaved = userRepository.findByEmail(email);

    if (Objects.isNull(userDetailsSaved)) {
      LOGGER.error("User not found with email: " + email);
      throw new AuthenticationException(
          ValidationErrors.USER_NOT_FOUND_ERROR + email);
    }
    if (!userDetailsSaved.getPassword().equals(password)) {
      LOGGER.error("Invalid password");
      throw new AuthenticationException("Invalid password");
    }

    userRepository.save(userDetailsSaved);
    UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
    userDetailsOutDto.setId(userDetailsSaved.getUserId());
    userDetailsOutDto.setIsLoggedIn(userDetailsSaved.getIsLoggedIn());
    userDetailsOutDto.setUserType(userDetailsSaved.getUsertype());
    userDetailsOutDto.setEmail(userDetailsSaved.getEmail());
    userDetailsOutDto.setPassword(userDetailsSaved.getPassword());
    userDetailsOutDto
        .setDeptId(userDetailsSaved.getDepartment().getDeptId());
    userDetailsOutDto.setName(userDetailsSaved.getName());

    return userDetailsOutDto;
  }

  /**
   * Changes the password for a user.
   *
   * @param changePasswordInDto The DTO containing password change information.
   * @return The DTO representing the updated user.
   * @throws AuthenticationException If the old password is incorrect.
   */
  @Override
  public UserDetailsOutDto changePassword(
      ChangePasswordInDto changePasswordInDto) {
    String email = changePasswordInDto.getEmail();
    String oldpassword = changePasswordInDto.getOldPassword();

    UserDetails savedUserDetails = userRepository.findByEmail(email);
    if (Objects.isNull(savedUserDetails)) {
      LOGGER.error("User not found with email: " + email);
      throw new AuthenticationException(
          ValidationErrors.USER_NOT_FOUND_ERROR + email);
    }
    if (!savedUserDetails.getPassword().equals(oldpassword)) {
      LOGGER.error("Invalid password");
      throw new AuthenticationException(
          ValidationErrors.INVALID_CREDENTIALS);
    } else if (savedUserDetails.getPassword().equals(oldpassword)) {
      savedUserDetails
          .setPassword(changePasswordInDto.getNewPassword());
      savedUserDetails.setIsLoggedIn(true);
      userRepository.save(savedUserDetails);
    }
//		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(savedUserDetails, UserDetailsOutDto.class);
    UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
    userDetailsOutDto.setName(savedUserDetails.getName());
    userDetailsOutDto.setEmail(savedUserDetails.getEmail());
    userDetailsOutDto.setUserType(savedUserDetails.getUsertype());
    userDetailsOutDto.setIsLoggedIn(savedUserDetails.getIsLoggedIn());
    userDetailsOutDto.setDepartment(
        savedUserDetails.getDepartment().getDeptName());
    userDetailsOutDto.setId(savedUserDetails.getUserId());

    return userDetailsOutDto;
  }

  /**
   * Retrieves a list of users with pagination.
   *
   * @param pageNumber The page number.
   * @param pageSize   The number of users per page.
   * @return A list of DTOs representing users.
   */
  @Override
  public List<UserDetailsOutDto> getAllUsers(Integer pageNumber,
      Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<UserDetails> userPage = userRepository.findAll(pageable);
    List<UserDetailsOutDto> list = new ArrayList<UserDetailsOutDto>();
    for (UserDetails userDetails : userPage) {
      UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
      userDetailsOutDto.setId(userDetails.getUserId());
      userDetailsOutDto.setEmail(userDetails.getEmail());
      userDetailsOutDto.setName(userDetails.getName());
      userDetailsOutDto
          .setDepartment(userDetails.getDepartment().getDeptName());
      list.add(userDetailsOutDto);
    }
    return list;
  }

  /**
   * Deletes a user by their unique identifier.
   *
   * @param userId The unique identifier of the user to delete.
   */
  @Override
  public void deleteUser(long userId) {
    userRepository.findById(userId).get();
    userRepository.deleteById(userId);
    return;
  }
}