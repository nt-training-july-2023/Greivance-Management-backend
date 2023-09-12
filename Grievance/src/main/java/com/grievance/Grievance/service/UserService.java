package com.grievance.Grievance.service;

import java.util.List;
import java.util.Optional;

import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.payload.LoginDto;

public interface UserService {

	
	public Optional<UserDetailsOutDto> loginService(LoginInDto loginDto);
	
	public List<UserDetailsOutDto> getAllUsers();

	public Optional<UserDetailsOutDto> createUser(UserDetailsInDto userDetailsInDto);

}
