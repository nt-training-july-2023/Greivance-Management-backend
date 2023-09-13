package com.grievance.Grievance.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.exception.ResourceNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;
	Department department;

	@Autowired
	ModelMapper modelMapper;

	// Create the Department

	@Override
	public Optional<DepartmentOutDto> createDepartment(DepartmentInDto departmentInDto) {
		Department department = this.departmentInDtoToDepartment(departmentInDto);
		Department savedDepartment = this.departmentRepo.save(department);
	    DepartmentOutDto departmentOutDtoSaved = this.departmentToDepartmentOutDto(savedDepartment);
		return Optional.ofNullable(departmentOutDtoSaved);
	}

	@Override
	public Optional<DepartmentOutDto> getDepartmentByName(String deptName){
		Department department = departmentRepo.findBydeptName(deptName);
		if(department!=null) {
			DepartmentOutDto departmentOutDto = this.departmentToDepartmentOutDto(department);
			return Optional.ofNullable(departmentOutDto);
		}
		return Optional.empty();
	}
	
	// get All department

	@Override
	public List<DepartmentOutDto> getAllDepartment() {
		List<Department> departments = this.departmentRepo.findAll();
		List<DepartmentOutDto> departmentList = departments.stream()
				.map(department -> this.departmentToDepartmentOutDto(department)).collect(Collectors.toList());
		return departmentList;
	}

	// Get department by Id

	@Override
	public DepartmentOutDto getDepartmentById(long deptId) {
		// TODO Auto-generated method stub
		Department department = this.departmentRepo.findById(deptId).get();
		return this.departmentToDepartmentOutDto(department);
	}

	// Updating the Department.

	@Override
	public DepartmentOutDto updateDepartment(DepartmentInDto departmentInDto, long deptId) {
		// TODO Auto-generated method stub
		Department department = this.departmentRepo.findById(deptId).get();
		department.setDeptName(departmentInDto.getDeptName());
		Department updateDepartment = this.departmentRepo.save(department);
		return this.departmentToDepartmentOutDto(updateDepartment);
	}

	// Delete department by Id.

	@Override
	public void deleteDepartmentById(long deptId) {
		this.departmentRepo.deleteById(deptId);
	}

	// Conversion methods
	// DepartmentInDto to Department.
	public Department departmentInDtoToDepartment(DepartmentInDto departmentInDto) {
		Department department = this.modelMapper.map(departmentInDto, Department.class);
		return department;
	}

	// Department to DepartmentOutDto.

	public DepartmentOutDto departmentToDepartmentOutDto(Department department) {
		DepartmentOutDto departmentOutDto = this.modelMapper.map(department, DepartmentOutDto.class);
		return departmentOutDto;
	}
}
