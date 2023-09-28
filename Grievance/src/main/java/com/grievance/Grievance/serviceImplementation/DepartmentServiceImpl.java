package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.exception.DuplicateEntryException;
import com.grievance.Grievance.exception.RecordNotFoundException;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.service.DepartmentService;

/**
 * Implementation of the DepartmentService interface providing operations
 * related to departments.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * Creates a new department based on the provided DepartmentInDto.
	 *
	 * @param departmentInDto The DTO containing department information.
	 * @return The DTO representing the created department.
	 */
	@Override
	public DepartmentOutDto createDepartment(DepartmentInDto departmentInDto) {
		// TODO Auto-generated method stub
		Department department = this.modelMapper.map(departmentInDto, Department.class);
		Department department2 = departmentRepository.findBydeptName(departmentInDto.getDeptName());
		if(Objects.isNull(department2)) {
			throw new DuplicateEntryException("Department Already Exist");
		}
		Department savedDepartment = departmentRepository.save(department);
		DepartmentOutDto departmentOutDto = this.modelMapper.map(savedDepartment, DepartmentOutDto.class);
		return departmentOutDto;
	}

	/**
	 * Retrieves a list of all departments.
	 *
	 * @return A list of DTOs representing all departments.
	 */
	@Override
	public List<DepartmentOutDto> getAllDepartments(Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Department> departmentsPage = departmentRepository.findAll(pageable);
		List<DepartmentOutDto> list = new ArrayList<DepartmentOutDto>();
		for (Department department : departmentsPage) {
			list.add(this.modelMapper.map(department, DepartmentOutDto.class));
		}
		return list;
	}

	/**
	 * Retrieves a department by its unique identifier.
	 *
	 * @param deptId The unique identifier of the department to retrieve.
	 * @return The DTO representing the retrieved department.
	 */
	@Override
	public DepartmentOutDto getDepartmentById(long deptId) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(deptId).get();
		if(department==null) {
			throw new RecordNotFoundException("Department with given Id not found");
		}
		DepartmentOutDto departmentOutDto = this.modelMapper.map(department, DepartmentOutDto.class);
		return departmentOutDto;
	}

	/**
	 * Deletes a department by its unique identifier.
	 *
	 * @param deptId The unique identifier of the department to delete.
	 */
	@Override
	public void deleteDepartment(long deptId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(deptId);
		return;

	}
}
