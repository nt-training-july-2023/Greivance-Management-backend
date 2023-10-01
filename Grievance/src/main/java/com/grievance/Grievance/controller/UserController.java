package com.grievance.Grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.service.UserService;

/**
 * Controller class for managing User-related operations.
 */
@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userservice;

	/**
	 * Create a new user.
	 *
	 * @param userDetailsInDto for creating the user.
	 * @return ResponseEntity containing the created UserDetailsOutDto.
	 */
	@PostMapping("/user")
	public ResponseEntity<UserDetailsOutDto> createUser(@Validated @RequestBody UserDetailsInDto userDetailsInDto) {
		System.out.println(userDetailsInDto.getUserType());
		UserDetailsOutDto userDetailsOutDto = userservice.createUser(userDetailsInDto);
		System.out.println(userDetailsInDto.getUserType());
		ResponseEntity userResponse = new ResponseEntity(userDetailsOutDto, HttpStatus.CREATED);
		return userResponse;
	}

	/**
	 * Authenticate a user by login credentials.
	 *
	 * @param loginInDto for user login.
	 * @return ResponseEntity containing the UserDetailsOutDto after successful
	 *         login.
	 */
	@PostMapping("/login")
	public ResponseEntity<UserDetailsOutDto> userLogin(@Validated @RequestBody LoginInDto loginInDto) {
		System.out.println("hyy1");
		UserDetailsOutDto userDetailsOutDto = userservice.userLogin(loginInDto);
		System.out.println("hyy2");
		ResponseEntity loginResponse = new ResponseEntity(userDetailsOutDto, HttpStatus.ACCEPTED);
		System.out.println("hyy3");
		return loginResponse;
	}

	/**
	 * Change the password for a user.
	 *
	 * @param changePasswordInDto for changing the user's password.
	 * @return ResponseEntity containing the UserDetailsOutDto after successful
	 *         password change.
	 */
	@PostMapping("/changepassword")
	public ResponseEntity<UserDetailsOutDto> changePassword(
			@Validated @RequestBody ChangePasswordInDto changePasswordInDto) {
		UserDetailsOutDto userDetailsOutDto = userservice.changePassword(changePasswordInDto);
		ResponseEntity passwordResponse = new ResponseEntity(userDetailsOutDto, HttpStatus.ACCEPTED);
		return passwordResponse;
	}

	/**
	 * Get a user by their ID.
	 *
	 * @param userId The ID of the user to retrieve.
	 * @return ResponseEntity containing the UserDetailsOutDto of the requested
	 *         user.
	 */
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDetailsOutDto> getUserById(@PathVariable("userId") long userId) {
		UserDetailsOutDto userDetailsOutDto = userservice.getUserById(userId);
		return ResponseEntity.ok(userDetailsOutDto);
	}

	/**
	 * Get a list of all users based on page number and page size.
	 *
	 * @param pageNumber The page number for pagination.
	 * @param pageSize   The page size for pagination.
	 * @return ResponseEntity containing a list of UserDetailsOutDto objects.
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserDetailsOutDto>> getAllUsers(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		List<UserDetailsOutDto> userDetailsOutDtos = userservice.getAllUsers(pageNumber, pageSize);
		return ResponseEntity.ok(userDetailsOutDtos);
	}

	/**
	 * Delete a user by their ID.
	 *
	 * @param userId The ID of the user to delete.
	 * @return ResponseEntity indicating a successful user deletion.
	 */
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {
		userservice.deleteUser(userId);
		return ResponseEntity.ok(null);
	}
}
