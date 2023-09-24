package com.grievance.Grievance.service;

import java.util.List;

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;

public interface DepartmentService {

	public DepartmentOutDto createDepartment(DepartmentInDto departmentInDto);

	public List<DepartmentOutDto> getAllDepartments();

	public DepartmentOutDto getDepartmentById(long deptId);

}
