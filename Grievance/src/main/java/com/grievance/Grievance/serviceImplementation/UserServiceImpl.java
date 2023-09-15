package com.grievance.Grievance.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.ResourceNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	UserDetails userdetails;
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Optional<UserDetailsOutDto> loginService(LoginInDto loginInDto) {
		// from database
		UserDetails userDetailsdb = userRepo.findByEmail(loginInDto.getEmail());
		System.out.println("Database"+userDetailsdb);
		
		if((userDetailsdb!=null) && userDetailsdb.getEmail().equals(loginInDto.getEmail()) ) {
			
			if(userDetailsdb.getPassword().equals(loginInDto.getPassword())) {
				UserDetailsOutDto userDetailsOutDto = this.UserDetailsToUserOutDto(userDetailsdb);
				System.out.println("useroutdto"+userDetailsOutDto);
				userDetailsdb.setIsLoggedIn(true);
				System.out.println("bool "+userDetailsdb.getIsLoggedIn());
			    userDetailsOutDto.setIsLoggedIn(true);
			    System.out.println(userDetailsOutDto.getIsLoggedIn());
			    System.out.println(userDetailsOutDto);
				return Optional.ofNullable(userDetailsOutDto);
				
			}
			else {
				throw new ResourceNotFoundException("User", "entered Wrong password", loginInDto.getPassword());
			}
		}
		else {
			throw new ResourceNotFoundException("User", "email",loginInDto.getEmail());
		}
		}

	// Create user

	@Override
	public Optional<UserDetailsOutDto> createUser(UserDetailsInDto userDetailsInDto) {
		// exception when email already exist
		UserDetails userdetails = this.UserInDtoToUserDetails(userDetailsInDto);
		userdetails.setIsLoggedIn(false);
		Department deptfromUser = departmentRepository.findBydeptName(userdetails.getDepartment().getDeptName());
		System.out.println("dept from user "+deptfromUser);
		userdetails.setDepartment(deptfromUser);
		UserDetails savedUser = this.userRepo.save(userdetails);
		UserDetailsOutDto saveduserOutDto = this.UserDetailsToUserOutDto(savedUser);
		System.out.println(saveduserOutDto);
		return Optional.ofNullable(saveduserOutDto);
	}

	// List users

	@Override
	public List<UserDetailsOutDto> getAllUsers() {
		List<UserDetails> users = this.userRepo.findAll();
		List<UserDetailsOutDto> userlist = users.stream().map(user -> this.UserDetailsToUserOutDto(user))
				.collect(Collectors.toList());
		return userlist;
	}

	// UserInDto to User

	public UserDetails UserInDtoToUserDetails(UserDetailsInDto userDetailsInDto) {
		UserDetails userDetails = this.modelMapper.map(userDetailsInDto, UserDetails.class);
		return userDetails;
	}

	// User to UserOutDto

	public UserDetailsOutDto UserDetailsToUserOutDto(UserDetails userDetails) {
		UserDetailsOutDto userDetailsOutDto = this.modelMapper.map(userDetails, UserDetailsOutDto.class);
		return userDetailsOutDto;
	}

	

}