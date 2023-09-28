package com.grievance.Grievance.ServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.service.DepartmentService;
import com.grievance.Grievance.serviceImplementation.DepartmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	@InjectMocks
	private DepartmentServiceImpl departmentService;

	@Test
	public void testCreateDepartment_Returns_DepartmentObject() {
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		
		DepartmentInDto departmentInDto = new DepartmentInDto();
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		
		when(modelMapper.map(departmentInDto, Department.class)).thenReturn(department);
		when(departmentRepository.save(department)).thenReturn(department);
		when(modelMapper.map(department, DepartmentOutDto.class)).thenReturn(departmentOutDto);
		assertEquals(departmentOutDto, departmentService.createDepartment(departmentInDto));
		
		}
	
	@Test
	public void testGetAllDepartments_Returns_AllDepartment() {
		
		Department department1 = new Department();
		department1.setDeptId(1);
		department1.setDeptName("IT");
		
		Department department2 = new Department();
		department2.setDeptId(2);
		department2.setDeptName("Engineer");
		
		
		        List<Department> departments = new ArrayList<>();
		        
		        departments.add(department1);
		        departments.add(department2);

		        Page<Department> departmentPage = new PageImpl<>(departments);

		        when(departmentRepository.findAll(any(Pageable.class))).thenReturn(departmentPage);

		        List<DepartmentOutDto> departmentOutDtos =departmentService.getAllDepartments(0, 10);

		        assertEquals(2, departmentOutDtos.size());
		        verify(departmentRepository, times(1)).findAll();
		        
	}
	
	
}
