package com.grievance.Grievance.ControllerTest;

import java.util.ArrayList;
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
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.controller.TicketController;
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
	public void testCreateTicket() throws Exception {

		Department department = new Department();
		UserDetails userDetails = new UserDetails();

		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setTicketTitle("Sample Ticket");
		ticketInDto.setTicketStatus(TicketStatus.Open);
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketType(TicketType.Grievance);
		ticketInDto.setDepartment(department);
		ticketInDto.setUserDetails(userDetails);

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setTicketId(1);

		Mockito.when(ticketService.createTicket(Mockito.any(TicketInDto.class))).thenReturn(ticketOutDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/grievance/ticket").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(ticketInDto))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

		Mockito.verify(ticketService, Mockito.times(1)).createTicket(Mockito.any(TicketInDto.class));
	}

	private String asJsonString(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testGetAllTickets() throws Exception {
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String email = "user@example.com";
		String type = "My Tickets";
		String filter = "All";

		List<TicketOutDto> ticketOutDtos = new ArrayList<>();
		TicketOutDto ticketOutDto1 = new TicketOutDto();
		ticketOutDto1.setTicketId(1L);
		ticketOutDtos.add(ticketOutDto1);

		Mockito.when(ticketService.getAllTickets(pageNumber, pageSize, email, type, filter)).thenReturn(ticketOutDtos);

		mockMvc.perform(MockMvcRequestBuilders.get("/grievance/tickets").param("pageNumber", pageNumber.toString())
				.param("pageSize", pageSize.toString()).header("email", email).param("type", type)
				.param("filter", filter).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

		Mockito.verify(ticketService, Mockito.times(1)).getAllTickets(pageNumber, pageSize, email, type, filter);
	}

	@Test
	public void testGetTicketById() throws Exception {
		long ticketId = 1L;

		TicketOutDto ticketOutDto = new TicketOutDto();
		ticketOutDto.setTicketId(ticketId);

		Mockito.when(ticketService.getTicketById(ticketId)).thenReturn(ticketOutDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/grievance/ticket/{ticketId}", ticketId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.ticketId").value(ticketId));

		Mockito.verify(ticketService, Mockito.times(1)).getTicketById(ticketId);
	}

	@Test
	public void testUpdateTicket() throws Exception {
		long ticketId = 1L;
		TicketUpdateDto ticketUpdateDto = new TicketUpdateDto();
		ticketUpdateDto.setContent("abcd");

		TicketOutDto updatedTicket = new TicketOutDto();
		updatedTicket.setTicketId(ticketId);
		updatedTicket.setDescription(ticketUpdateDto.getContent());

		Mockito.when(ticketService.updateTicket(Mockito.any(TicketUpdateDto.class), Mockito.eq(ticketId)))
				.thenReturn(updatedTicket);

		mockMvc.perform(MockMvcRequestBuilders.put("/grievance/ticket/{ticketId}", ticketId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(ticketUpdateDto)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.ticketId").value(ticketId));

		Mockito.verify(ticketService, Mockito.times(1)).updateTicket(Mockito.any(TicketUpdateDto.class),
				Mockito.eq(ticketId));
	}

}
