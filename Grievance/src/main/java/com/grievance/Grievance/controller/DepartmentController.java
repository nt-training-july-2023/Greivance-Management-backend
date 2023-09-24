package com.grievance.Grievance.controller;

import java.util.List;

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

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.service.DepartmentService;

@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/department")
	public ResponseEntity<DepartmentOutDto> createDepartment(@Validated @RequestBody DepartmentInDto departmentInDto) {
		DepartmentOutDto departmentOutDto = departmentService.createDepartment(departmentInDto);
		ResponseEntity createdResponse = new ResponseEntity(departmentOutDto, HttpStatus.CREATED);
		return createdResponse;
	}

	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentOutDto>> getAllDepartment() {
		List<DepartmentOutDto> departmentOutDtoslist = departmentService.getAllDepartments();
		return ResponseEntity.ok(departmentOutDtoslist);
	}

	@GetMapping("/department/{deptId}")
	public ResponseEntity<DepartmentOutDto> getDepartmentById(@PathVariable("deptId") long deptId) {
		DepartmentOutDto departmentOutDto = departmentService.getDepartmentById(deptId);
		return ResponseEntity.ok(departmentOutDto);
	}
}
