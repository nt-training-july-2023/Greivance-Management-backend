package com.grievance.Grievance.service;

import java.util.List;

import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;

/**
 * The service methods in this interface are responsible for handling business
 * logic related to users .
 *
 */
public interface UserService {

	/**
	 * Creates a new user
	 *
	 * @param userDetailsInDto The DTO containing user details to create.
	 * @return The created userOutDto
=	 */
	UserDetailsOutDto createUser(UserDetailsInDto userDetailsInDto);

	/**
	 * Performs user login
	 *
	 * @param loginInDto The DTO containing login credentials.
	 * @return The userOutDto.
	 */
	UserDetailsOutDto userLogin(LoginInDto loginInDto);

	/**
	 * Changes the password .
	 *
	 * @param changePasswordInDto The DTO containing old and new password details.
	 * @return The updated userOutDto.
	 */
	UserDetailsOutDto changePassword(ChangePasswordInDto changePasswordInDto);

	/**
	 * Retrieves a user by their unique identifier (userId).
	 *
	 * @param userId The unique identifier of the user to retrieve.
	 * @return The userOutDto.
	 */
	UserDetailsOutDto getUserById(long userId);

	/**
	 * Retrieves a paginated list of all users in the system.
	 * @param pageNumber The page number of the desired page.
	 * @param pageSize   The maximum number of user records to include in each page.
	 * @return A paginated list of users.
	 */
	public List<UserDetailsOutDto> getAllUsers(Integer pageNumber, Integer pageSize);

	/**
	 * Deletes a user based on their unique identifier (userId).
	 *
	 * @param userId The unique identifier of the user to delete.
	 */
	public void deleteUser(long userId);
}
