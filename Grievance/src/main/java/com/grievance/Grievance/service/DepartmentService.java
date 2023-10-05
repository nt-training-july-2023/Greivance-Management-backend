package com.grievance.Grievance.service;

import java.util.List;

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;

/**
 * The service methods in this interface are responsible for handling business
 * logic related to departments.
 */
public interface DepartmentService {
	/**
	 * Creates a new department.
	 *
	 * @param departmentInDto The DTO containing department details to create.
	 * @return DepartmentOutDto.
	 */
	 DepartmentOutDto createDepartment(DepartmentInDto departmentInDto);

	/**
	 * Retrieves a list of all departments in the system.
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @return A list of departmentOutDtos.
	 */
	 List<DepartmentOutDto> getAllDepartments(Integer pageNumber, Integer pageSize);

	/**
	 * Retrieves a department by its unique identifier (deptId).
	 *
	 * @param deptId The unique identifier of the department to retrieve.
	 * @return The departmentOutDto
	 */
	 DepartmentOutDto getDepartmentById(long deptId);

	/**
	 * Deletes a department by its unique id (deptId).
	 *
	 * @param deptId The unique id of the department to delete.
	 */
	 void deleteDepartment(long deptId);

}
