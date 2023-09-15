package com.grievance.Grievance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// When the userType is ADMIN.
	// save department API / Create new Department API.

	@PostMapping("/department")
	public ResponseEntity<DepartmentOutDto> createDepartment(@Validated @RequestBody DepartmentInDto departmentInDto) {
		Optional<DepartmentOutDto> departmentSavedDto = departmentService.createDepartment(departmentInDto);
		return new ResponseEntity(departmentSavedDto, HttpStatus.CREATED);
	}

	// get all departments

	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentOutDto>> getAllDepartment() {
		List<DepartmentOutDto> departmentList = departmentService.getAllDepartment();
		return ResponseEntity.ok(departmentList);
	}

	@GetMapping("/department/{deptName}")
	public ResponseEntity<DepartmentOutDto> getDepartmentByName( @PathVariable ("deptName") String deptName){
		Optional<DepartmentOutDto> departmentOutDto = departmentService.getDepartmentByName(deptName);
		return new ResponseEntity(departmentOutDto , HttpStatus.ACCEPTED);
	}
	// update the department

	@PutMapping("/department/{dept_id}")
	public ResponseEntity<DepartmentOutDto> updateDepartment(@RequestBody DepartmentInDto departmentInDto,
			@PathVariable("dept_id") long deptId) {
		DepartmentOutDto updatedSaveDepartmentOutDto = this.departmentService.updateDepartment(departmentInDto,
				deptId);
		return new ResponseEntity<>(updatedSaveDepartmentOutDto, HttpStatus.OK);
	}

	// get department by Id

	@GetMapping("/department/{dept_id}")
	public ResponseEntity<DepartmentOutDto> getDepartmentById(@PathVariable("dept_id") long deptId) {
		DepartmentOutDto departmentDto = this.departmentService.getDepartmentById(deptId);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

	// Delete department by Id

	@DeleteMapping("/department/{dept_id}")
	public void deleteDepartmentById(@PathVariable("dept_id") long deptId) {
		this.departmentService.deleteDepartmentById(deptId);
		return;
	}
}
