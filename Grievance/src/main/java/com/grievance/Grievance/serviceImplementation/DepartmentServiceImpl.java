package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
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
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentOutDto createDepartment(DepartmentInDto departmentInDto) {
		// TODO Auto-generated method stub	
		System.out.println("In"+departmentInDto);
        Department department = this.modelMapper.map(departmentInDto, Department.class);
        System.out.println("Dep"+department);
		Department savedDepartment = departmentRepository.save(department);
		System.out.println("save"+savedDepartment);
		DepartmentOutDto departmentOutDto = this.modelMapper.map(savedDepartment, DepartmentOutDto.class);
		System.out.println("out"+departmentOutDto);
		return departmentOutDto;
	}

	@Override
	public List<DepartmentOutDto> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentRepository.findAll();
		List<DepartmentOutDto> list = new ArrayList<DepartmentOutDto>();
		for (Department department : departments) {
			list.add(this.modelMapper.map(department,DepartmentOutDto.class));
		}
		return list;	
	}
	@Override
	public DepartmentOutDto getDepartmentById(long deptId) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(deptId).get();
		DepartmentOutDto departmentOutDto = this.modelMapper.map(department, DepartmentOutDto.class);
		return departmentOutDto;
	}
}
