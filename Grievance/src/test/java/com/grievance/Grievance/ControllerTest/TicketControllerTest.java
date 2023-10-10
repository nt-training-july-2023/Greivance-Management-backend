package com.grievance.Grievance.ControllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Optional;

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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.DepartmentInDto;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.CommentOutDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.controller.TicketController;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.service.TicketService;


@ExtendWith(MockitoExtension.class)
public class TicketControllerTest {

	@Mock
    TicketService ticketService;
	
	@InjectMocks 
	TicketController ticketController;
	
	@Autowired
	MockMvc mockMvc;

	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
		objectMapper = new ObjectMapper();
		
	}
	
	@Test
	public void testCreateTicket_Returns_TicketObject() throws Exception{
		
		TicketInDto ticketInDto = new TicketInDto();
	    ticketInDto.setTicketTitle("Technical Issue");
	    ticketInDto.setTicketType(TicketType.valueOf("Grievance"));
	    ticketInDto.setDescription("abcd");
	    ticketInDto.setUserDetails(new UserDetails());
//	    ticketInDto.setComments(new ArrayList<CommentOutDto>());
	    
	    TicketOutDto ticketOutDto = new TicketOutDto();
	    ticketOutDto.setComments(new ArrayList<Comment>());
	    ticketOutDto.setDepartment(new DepartmentOutDto());
	    ticketOutDto.setTicketStatus(TicketStatus.valueOf("Open"));
	    ticketOutDto.setDescription("abcd");
	    ticketOutDto.setTicketId(1);
	    ticketOutDto.setUserDetails(new UserDetailsOutDto());
	    ticketOutDto.setCreatedAt(null);
	    ticketOutDto.setUpdatedAt(null);
	    ticketOutDto.setTicketTitle("Technical Issue");
	   
when(ticketService.createTicket(Mockito.any(TicketInDto.class))).thenReturn(ticketOutDto);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/ticket").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(ticketInDto)).header("email", "sneha@nucleusteq.com")
				.header("password", "Sneha@01")).andExpect(status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	    
	    
	}
	
	@Test
	public void testTicketOutDto_Returns_TicketList() throws Exception{
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setDepartment(new Department());
		ticketInDto.setDescription("absc");
		ticketInDto.setTicketStatus(TicketStatus.Open);
		ticketInDto.setTicketTitle("abcd");
		ticketInDto.setTicketType(TicketType.Grievance);
		ticketInDto.setUserDetails(new UserDetails());
		
		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setDepartment(new DepartmentOutDto());
		ticketOutDto.setComments(new ArrayList<Comment>());
		ticketOutDto.setCreatedAt(null);
		ticketOutDto.setDescription("absc");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setUserDetails(new UserDetailsOutDto());
		ticketOutDto.setTicketStatus(TicketStatus.Open);
		ticketOutDto.setUpdatedAt(null);
		ticketOutDto.setTicketType(TicketType.Grievance);
		
		
		
	}
	
}
