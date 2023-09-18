package com.grievance.Grievance.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.Grievance.InDto.ChangePasswordInDto;
import com.grievance.Grievance.InDto.LoginInDto;
import com.grievance.Grievance.InDto.UserDetailsInDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/user")
	public ResponseEntity<UserDetailsOutDto> createUser(@Validated @RequestBody UserDetailsInDto userDetailsInDto) {
		System.out.println("userservice"+userDetailsInDto.getUserType());
		UserDetailsOutDto userDetailsOutDto = userservice.createUser(userDetailsInDto);
//		System.out.println("controller"+userDetailsOutDto.getIsLoggedIn());
		System.out.println();
		ResponseEntity userResponse = new ResponseEntity(userDetailsOutDto,HttpStatus.CREATED);
		return userResponse;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDetailsOutDto> userLogin(@Validated @RequestBody LoginInDto loginInDto){
		UserDetailsOutDto userDetailsOutDto = userservice.userLogin(loginInDto);
		System.out.println("controller "+userDetailsOutDto.getIsLoggedIn());
		ResponseEntity loginResponse = new ResponseEntity(userDetailsOutDto,HttpStatus.ACCEPTED);
		return loginResponse;
	}
	
	@PostMapping("/changepassword")
	public ResponseEntity<UserDetailsOutDto> changePassword(@Validated @RequestBody ChangePasswordInDto changePasswordInDto){
		UserDetailsOutDto userDetailsOutDto = userservice.changePassword(changePasswordInDto);
		ResponseEntity passwordResponse = new ResponseEntity(userDetailsOutDto,HttpStatus.ACCEPTED);
		return passwordResponse;
}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDetailsOutDto> getUserById(@PathVariable ("userId") long userId){
		UserDetailsOutDto userDetailsOutDto = userservice.getUserById(userId);
		return ResponseEntity.ok(userDetailsOutDto);
	}
}
