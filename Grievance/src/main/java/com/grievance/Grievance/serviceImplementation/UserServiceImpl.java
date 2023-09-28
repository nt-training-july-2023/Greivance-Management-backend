package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.AuthenticationException;
import com.grievance.Grievance.exception.RecordNotFoundException;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.UserService;

/**
 * Implementation of the UserService interface providing operations related to
 * users.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates a new user based on the provided UserDetailsInDto.
	 *
	 * @param userDetailsInDto The DTO containing user details.
	 * @return The DTO representing the created user.
	 */
	@Override
	public UserDetailsOutDto createUser(UserDetailsInDto userDetailsInDto) {
		// TODO Auto-generated method stub
		UserDetails userDetails = this.modelMapper.map(userDetailsInDto, UserDetails.class);
		UserDetails userDetails2 = userRepository.findByEmail(userDetailsInDto.getEmail());
		if (Objects.nonNull(userDetails2)) {
			throw new DuplicateKeyException("Email Already Exist");
		}
		UserDetails savedUser = userRepository.save(userDetails);
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(savedUser, UserDetailsOutDto.class);
//		savedUser.setIsLoggedIn(false);
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
		// TODO Auto-generated method stub
		String email = loginInDto.getEmail();
		String password = loginInDto.getPassword();
		UserDetails userDetailsSaved = userRepository.findByEmail(email);
		if (Objects.isNull(userDetailsSaved)) {
			throw new AuthenticationException("User not found with email: " + email);
		}
		if (!userDetailsSaved.getPassword().equals(password)) {
			throw new AuthenticationException("Invalid password");
		}
		userRepository.save(userDetailsSaved);
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(userDetailsSaved, UserDetailsOutDto.class);
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
	public UserDetailsOutDto changePassword(ChangePasswordInDto changePasswordInDto) {
		// TODO Auto-generated method stub
		String oldemail = changePasswordInDto.getEmail();
		String oldpassword = changePasswordInDto.getOldPassword();

		UserDetails savedUserDetails = userRepository.findByEmail(oldemail);
		if (Objects.isNull(savedUserDetails)) {
			throw new AuthenticationException("User not found with email: " + oldemail);
		}
		if (!savedUserDetails.getPassword().equals(oldpassword)) {
			throw new AuthenticationException("Invalid password");
		} else if (savedUserDetails.getPassword().equals(oldpassword)) {
			savedUserDetails.setPassword(changePasswordInDto.getNewPassword());
			savedUserDetails.setIsLoggedIn(true);
			userRepository.save(savedUserDetails);
		}

		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(savedUserDetails, UserDetailsOutDto.class);
		return userDetailsOutDto;
	}

	/**
	 * Retrieves a user by their unique identifier.
	 *
	 * @param userId The unique identifier of the user to retrieve.
	 * @return The DTO representing the retrieved user.
	 */
	@Override
	public UserDetailsOutDto getUserById(long userId) {
		// TODO Auto-generated method stub
		UserDetails userDetails = userRepository.findById(userId)
				.orElseThrow(() -> new RecordNotFoundException("User with given Id not found"));
//		if (userDetails.isEmpty()) {
//			throw new RecordNotFoundException("User with given Id not found");
//		}
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(userDetails, UserDetailsOutDto.class);
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
	public List<UserDetailsOutDto> getAllUsers(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<UserDetails> userPage = userRepository.findAll(pageable);
		List<UserDetailsOutDto> list = new ArrayList<UserDetailsOutDto>();
		for (UserDetails userDetails : userPage) {
			list.add(this.modelMapper.map(userDetails, UserDetailsOutDto.class));
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
		// TODO Auto-generated method stub
		UserDetails userDetails = userRepository.findById(userId).get();
		if (Objects.isNull(userDetails)) {
			throw new RecordNotFoundException("User with given Id not found");
		}
		userRepository.deleteById(userId);
		return;
	}
}