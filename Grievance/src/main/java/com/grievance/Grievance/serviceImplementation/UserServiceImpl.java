package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.grievance.Grievance.exception.ResourceNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetailsOutDto createUser(UserDetailsInDto userDetailsInDto) {
		// TODO Auto-generated method stub
		UserDetails userDetails = this.modelMapper.map(userDetailsInDto, UserDetails.class);
//		UserDetails user = userRepository.findByEmail(userDetailsInDto.getEmail());
//		if(user.getEmail().equals(userDetailsInDto.getEmail())) {
//			throw new DuplicateEntryException("User with entered email already exist");
//		}
		UserDetails savedUser = userRepository.save(userDetails);
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(savedUser, UserDetailsOutDto.class);
		return userDetailsOutDto;
	}

	@Override
	public UserDetailsOutDto userLogin(LoginInDto loginInDto) {
		// TODO Auto-generated method stub
		String email = loginInDto.getEmail();
		String password = loginInDto.getPassword();
		UserDetails userDetailsSaved = userRepository.findByEmail(email);
		if(userDetailsSaved==null) {
			
			throw new AuthenticationException("User not found with email: " + email);
		}
		if(!userDetailsSaved.getPassword().equals(password)) {
			throw new AuthenticationException("Invalid password");
		}
		userDetailsSaved.setIsLoggedIn(true);
		userRepository.save(userDetailsSaved);
		System.out.println("userser"+userDetailsSaved.getIsLoggedIn());
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(userDetailsSaved, UserDetailsOutDto.class);
		System.out.println("userser after mapp"+userDetailsOutDto.getIsLoggedIn());
		return userDetailsOutDto;
	}

	@Override
	public UserDetailsOutDto changePassword(ChangePasswordInDto changePasswordInDto) {
		// TODO Auto-generated method stub
		String oldemail = changePasswordInDto.getEmail();
		String oldpassword = changePasswordInDto.getOldPassword();
		
		UserDetails savedUserDetails = userRepository.findByEmail(oldemail);
		if(savedUserDetails == null) {
			throw new AuthenticationException("User not found with email: " + oldemail);
		}
		if(!savedUserDetails.getPassword().equals(oldpassword)) {
			throw new AuthenticationException("Invalid password");
		}
		else if(savedUserDetails.getPassword().equals(oldpassword)) {
			savedUserDetails.setPassword(changePasswordInDto.getNewPassword());
			savedUserDetails.setIsLoggedIn(true);
			userRepository.save(savedUserDetails);
//			System.out.println("new pass"+savedUserDetails.getPassword());
		}
		
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(savedUserDetails, UserDetailsOutDto.class);
		return userDetailsOutDto;
	}

	@Override
	public UserDetailsOutDto getUserById(long userId) {
		// TODO Auto-generated method stub
		UserDetails userDetails = userRepository.findById(userId).get();
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(userDetails, UserDetailsOutDto.class);
		return userDetailsOutDto;	
	}

	@Override
	public List<UserDetailsOutDto> getAllUsers() {
		// TODO Auto-generated method stub
//		List<UserDetails> l
		
		return null;
	}
	
	
	

	

	

}