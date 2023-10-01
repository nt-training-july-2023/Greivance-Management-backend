package com.grievance.Grievance.ControllerTest;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.annotations.ArrayBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.controller.DepartmentController;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.service.DepartmentService;
@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

	
	@Mock 
	DepartmentService departmentService;
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks 
	DepartmentController departmentController;
	
	private ObjectMapper objectMapper;
	
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
		objectMapper = new ObjectMapper();
	}
	
	@Test
	public void testDepartmentController_Returns_DepartmentObject() throws Exception{
		
	DepartmentInDto departmentInDto = new DepartmentInDto();
	departmentInDto.setDeptName("IT");
	
	DepartmentOutDto departmentOutDto = new DepartmentOutDto();
	departmentOutDto.setDeptId(1);
	departmentOutDto.setDeptName("IT");
	departmentOutDto.setUserDetails(new ArrayList<UserDetailsOutDto>());
	departmentOutDto.setTickets(new ArrayList<TicketOutDto>());
	
	when(departmentService.createDepartment(Mockito.any(DepartmentInDto.class))).thenReturn(departmentOutDto);
	mockMvc.perform(MockMvcRequestBuilders.post("/grievance/department").contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsBytes(departmentInDto)).header("email", "sneha@nucleusteq.com")
			.header("password", "Sneha@01")).andExpect(status().isCreated());
			
	}
	
	@Test
	public void testDepartmentController_Returns_DepartmentList() throws Exception{
		DepartmentInDto departmentInDto = new DepartmentInDto();
		departmentInDto.setDeptName("IT");	
		
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		departmentOutDto.setUserDetails(new ArrayList<UserDetailsOutDto>());
		departmentOutDto.setTickets(new ArrayList<TicketOutDto>());
		
//		List<DepartmentOutDto> list = new Arra
		
		
		
//		when(departmentService.getAllDepartments(anyInt(), anyInt())).thenReturn(List<DepartmentOutDto>);
		
	
		
	}
}
