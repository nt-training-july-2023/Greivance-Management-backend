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
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.controller.TicketController;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.TicketStatus;
import com.grievance.Grievance.entity.TicketType;
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
	    ticketInDto.setTicketType(TicketType.valueOf("GRIEVANCE"));
	    ticketInDto.setDescription("abcd");
	    ticketInDto.setUserDetails(new UserDetails());
	    ticketInDto.setComments(new ArrayList<Comment>());
	    
	    TicketOutDto ticketOutDto = new TicketOutDto();
	    ticketOutDto.setComments(new ArrayList<Comment>());
	    ticketOutDto.setDepartment(new Department());
	    ticketOutDto.setTicketStatus(TicketStatus.valueOf("BEING_ADDRESSED"));
	    ticketOutDto.setDescription("abcd");
	    ticketOutDto.setTicketId(1);
	    ticketOutDto.setUserDetails(new UserDetails());
	    ticketOutDto.setCreatedAt(null);
	    ticketOutDto.setUpdatedAt(null);
	    ticketOutDto.setTicketTitle("Technical Issue");
	   
when(ticketService.createTicket(Mockito.any(TicketInDto.class))).thenReturn(Optional.of(ticketOutDto));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/saveTicket").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(ticketInDto)).header("email", "sneha@nucleusteq.com")
				.header("password", "Sneha@01")).andExpect(status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	    
	    
	}
	
	
	
}
