package com.grievance.Grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.service.DepartmentService;
/**
 * Controller class for managing Department-related operations.
 */
@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	/**
	 * Create a new department.
	 *
	 * @param departmentInDto for creating the department.
	 * @return ResponseEntity containing the created DepartmentOutDto.
	 */
	@PostMapping("/department")
	public ResponseEntity<DepartmentOutDto> createDepartment(@Validated @RequestBody DepartmentInDto departmentInDto) {
		DepartmentOutDto departmentOutDto = departmentService.createDepartment(departmentInDto);
		ResponseEntity createdResponse = new ResponseEntity(departmentOutDto, HttpStatus.CREATED);
		return createdResponse;
	}
	/**
	 * Get a list of all departments.
	 *
	 * @param pageNumber The page number for pagination.
	 * @param pageSize   The page size for pagination.
	 * @return ResponseEntity containing a list of DepartmentOutDto objects.
	 */
	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentOutDto>> getAllDepartment(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		List<DepartmentOutDto> departmentOutDtoslist = departmentService.getAllDepartments(pageNumber,pageSize);
		return ResponseEntity.ok(departmentOutDtoslist);
	}
	/**
	 * Get a department by its ID.
	 *
	 * @param deptId The ID of the department to retrieve.
	 * @return ResponseEntity containing the DepartmentOutDto of the requested
	 *         department.
	 */
	@GetMapping("/department/{deptId}")
	public ResponseEntity<DepartmentOutDto> getDepartmentById(@PathVariable("deptId") long deptId) {
		DepartmentOutDto departmentOutDto = departmentService.getDepartmentById(deptId);
		return ResponseEntity.ok(departmentOutDto);
	}
	/**
	 * Delete a department by its ID.
	 *
	 * @param deptId The ID of the department to delete.
	 * @return ResponseEntity with a null body to indicate successful deletion.
	 */
	@DeleteMapping("/department/{deptId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("deptId") long deptId) {
		departmentService.deleteDepartment(deptId);
		return ResponseEntity.ok(null);
	}
}
