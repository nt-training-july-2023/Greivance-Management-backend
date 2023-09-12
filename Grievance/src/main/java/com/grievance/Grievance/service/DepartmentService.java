package com.grievance.Grievance.service;

import java.util.List;
import java.util.Optional;

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;

public interface DepartmentService {

	public List<DepartmentOutDto> getAllDepartment();

	public DepartmentOutDto getDepartmentById(long deptId);

	public Optional<DepartmentOutDto> createDepartment(DepartmentInDto departmentInDto);

	public DepartmentOutDto updateDepartment(DepartmentInDto departmentInDto, long deptId);

	public void deleteDepartmentById(long deptId);
	
	public Optional<DepartmentOutDto> getDepartmentByName (String deptName);
}
