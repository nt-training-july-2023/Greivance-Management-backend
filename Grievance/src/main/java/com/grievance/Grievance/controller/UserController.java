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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/login")
	public ResponseEntity<UserDetailsOutDto> loginService(@Validated @RequestBody LoginInDto loginInDto) {
		Optional<UserDetailsOutDto> userOutdto = this.userservice.loginService(loginInDto);

		if (userOutdto != null) {
			return new ResponseEntity(userOutdto, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	}

	// save user API / Create new User API.
	@PostMapping("/user")
	public ResponseEntity<UserDetailsOutDto> createUser(@Valid @RequestBody UserDetailsInDto userDetailsInDto) {
		System.out.println(userDetailsInDto.getDepartment().getDeptName());
		System.out.println(userDetailsInDto.toString());
		Optional<UserDetailsOutDto> userSavedOutDto = this.userservice.createUser(userDetailsInDto);
		return new ResponseEntity(userSavedOutDto,HttpStatus.CREATED);
	}

	// get all users
	@GetMapping("/users")
	public ResponseEntity<List<UserDetailsOutDto>> getAllUsers() {
		List<UserDetailsOutDto> listDto = this.userservice.getAllUsers();
		return ResponseEntity.ok(listDto);
	}
}
