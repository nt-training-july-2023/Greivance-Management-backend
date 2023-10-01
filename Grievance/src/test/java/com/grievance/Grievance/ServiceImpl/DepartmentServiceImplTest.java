package com.grievance.Grievance.ServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.DuplicateEntryException;
import com.grievance.Grievance.exception.RecordNotFoundException;
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
	public void testCreateDepartment_Returns_DepartmentObject() throws Exception{
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("IT");
		
		DepartmentInDto departmentInDto = new DepartmentInDto();
		departmentInDto.setDeptName("Test Department");

		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
        departmentOutDto.setDeptName("Test Department");
        
        Department savedDepartment = new Department();
        savedDepartment.setDeptId(1L);
        savedDepartment.setDeptName("Test Department");
		
		when(modelMapper.map(departmentInDto, Department.class)).thenReturn(department);
		when(departmentRepository.save(department)).thenReturn(department);
		when(modelMapper.map(department, DepartmentOutDto.class)).thenReturn(departmentOutDto);
		assertEquals(departmentOutDto, departmentService.createDepartment(departmentInDto));
		

		
		}
	
	@Test
    public void testCreateDepartmentWithDuplicateName() throws Exception{
        
        DepartmentInDto departmentInDto = new DepartmentInDto();
        departmentInDto.setDeptName("Test Department");

        Department existingDepartment = new Department();
        existingDepartment.setDeptName("Test Department");

       
        when(departmentRepository.findBydeptName("Test Department")).thenReturn(existingDepartment);

        assertThrows(DuplicateEntryException.class, () -> departmentService.createDepartment(departmentInDto));
        verify(departmentRepository).findBydeptName("Test Department");
    }
	

	
	@Test
	public void testGetAllDepartments_Returns_AllDepartment() {
		
		 int pageNumber = 0;
	        int pageSize = 10;
	        
	        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
	        
		Department department1 = new Department();
		department1.setDeptId(1);
		department1.setDeptName("IT");
		
		Department department2 = new Department();
		department2.setDeptId(2);
		department2.setDeptName("Engineer");
		
		List<Department> departmentList = Arrays.asList(department1, department2);
        Page<Department> departmentPage = new PageImpl<>(departmentList, pageable, departmentList.size());
        
        DepartmentOutDto departmentOutDto1 = new DepartmentOutDto();
        departmentOutDto1.setDeptId(1L);
        departmentOutDto1.setDeptName("Department 1");

        DepartmentOutDto departmentOutDto2 = new DepartmentOutDto();
        departmentOutDto2.setDeptId(2L);
        departmentOutDto2.setDeptName("Department 2");
		
		
        when(departmentRepository.findAll(pageable)).thenReturn(departmentPage);
        List<DepartmentOutDto> departmentOutDtos = departmentService.getAllDepartments(pageNumber, pageSize);

        assertNotNull(departmentOutDtos);
        assertEquals(2, departmentOutDtos.size());

        verify(departmentRepository).findAll(pageable);
      
		        
	}
	
	 @Test
	    public void testGetDepartmentById() {
	        
	        long deptId = 1;
	        Department department = new Department();
	        department.setDeptId(deptId);
	        department.setDeptName("Department 1");

	        DepartmentOutDto departmentOutDto = new DepartmentOutDto();
	        departmentOutDto.setDeptId(deptId);
	        departmentOutDto.setDeptName("Department 1");

	        when(departmentRepository.findById(deptId)).thenReturn(Optional.of(department));
	        when(modelMapper.map(department, DepartmentOutDto.class)).thenReturn(departmentOutDto);

	        
	       
	        DepartmentOutDto result = departmentService.getDepartmentById(deptId);

	        
	        assertNotNull(result);
	        assertEquals(deptId, result.getDeptId());
	        assertEquals("Department 1", result.getDeptName());

	        verify(departmentRepository).findById(deptId);
	        verify(modelMapper).map(department, DepartmentOutDto.class);
	    }

	    @Test
	    public void testGetDepartmentById_NotFound() {
	       
	        long deptId = 1;

	        when(departmentRepository.findById(deptId)).thenReturn(Optional.empty());

	    
	        assertThrows(NoSuchElementException.class, () -> {
	            departmentService.getDepartmentById(deptId);
	        });


	        verify(departmentRepository).findById(deptId);
	    }
	    
	    @Test
	    public void testDeleteDepartment() {
	       
	        long deptId = 1L;

	        
	        doNothing().when(departmentRepository).deleteById(deptId);

	      
	        departmentService.deleteDepartment(deptId);

	        
	        verify(departmentRepository).deleteById(deptId);
	    }
	}
	
	

