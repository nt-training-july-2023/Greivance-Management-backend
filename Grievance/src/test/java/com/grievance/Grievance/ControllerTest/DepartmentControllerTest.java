package com.grievance.Grievance.ControllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.controller.DepartmentController;
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
	public void testDepartmentController_Returns_DepartmentObject() throws Exception {

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
	public void testGetAllDepartments() throws Exception {

		List<DepartmentOutDto> expectedDepartments = Arrays.asList(new DepartmentOutDto(), new DepartmentOutDto());

		Mockito.when(departmentService.getAllDepartments(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(expectedDepartments);

		when(departmentService.getAllDepartments(any(Integer.class), any(Integer.class)))
				.thenReturn(Arrays.asList(new DepartmentOutDto(), new DepartmentOutDto()));

		mockMvc.perform(MockMvcRequestBuilders.get("/grievance/departments").param("pageNumber", "0")
				.param("pageSize", "10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testGetDepartmentById() throws Exception {

		long deptId = 1;
		DepartmentOutDto expectedDepartment = new DepartmentOutDto();

		Mockito.when(departmentService.getDepartmentById(deptId)).thenReturn(expectedDepartment);

		mockMvc.perform(MockMvcRequestBuilders.get("/grievance/department/{deptId}", deptId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testDeleteDepartment() throws Exception {

		long deptId = 1;
		mockMvc.perform(MockMvcRequestBuilders.delete("/grievance/department/{deptId}", deptId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(departmentService, Mockito.times(1)).deleteDepartment(deptId);
	}
}
