package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.UserDetails;

/**
 * It provides CRUD
 * (Create, Read, Update, Delete) operations for UserDetails entity.
 */
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	/**
	 * Retrieve user details by their email.
	 *
	 * @param email The email address to search for.
	 * @return The user details associated with the specified email.
	 *
	 */
	UserDetails findByEmail(String email);

	/**
	 * Check if a user with the specified email and password exists.
	 *
	 * @param email    The email address to check.
	 * @param password The password to check.
	 * @return True if a user with the specified email and password exists,
	 *         otherwise false.
	 */
	boolean existsByEmailAndPassword(String email, String password);

	/**
	 * Check if a user with the specified email, password, and user type exists.
	 *
	 * @param email    The email address to check.
	 * @param password The password to check.
	 * @param userType To check the type of the user.
	 *
	 * @return True if a user with the specified email, password, and user type
	 *         exists, otherwise false.
	 */
	boolean existsByEmailAndPasswordAndUsertype(String email, String password, UserType admin);

}