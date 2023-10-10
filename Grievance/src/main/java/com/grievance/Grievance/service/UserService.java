package com.grievance.Grievance.service;

import java.util.List;
import java.util.Optional;

import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;

public interface UserService {
	
	UserDetailsOutDto createUser(UserDetailsInDto userDetailsInDto);

	UserDetailsOutDto userLogin(LoginInDto loginInDto);
	
	UserDetailsOutDto changePassword(ChangePasswordInDto changePasswordInDto);
	
	UserDetailsOutDto getUserById(long userId);
	
	List<UserDetailsOutDto> getAllUsers();
}
