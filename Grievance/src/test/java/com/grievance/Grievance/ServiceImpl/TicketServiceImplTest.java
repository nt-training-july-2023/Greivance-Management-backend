package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.controller.DepartmentController;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.TicketServiceImpl;


@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private TicketRepository ticketRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private TicketServiceImpl ticketService;

	@Test
	public void testCreateTicket_Returns_TicketObject() {
		
		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setDepartment(new Department());
		ticketInDto.setTicketStatus(TicketStatus.Open);
		ticketInDto.setDescription("abcd");
		ticketInDto.setTicketTitle("Technical Issue");
		ticketInDto.setTicketType(TicketType.Grievance);
		ticketInDto.setUserDetails(new UserDetails());
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
//		ticket.setTicketStatus(TicketStatus.Open);
		ticket.setTicketTitle("Technical Issue");
		ticket.setTicketType(TicketType.Grievance);
		ticket.setUserDetails(new UserDetails());
			
		when(modelMapper.map(ticketInDto, Ticket.class)).thenReturn(ticket);
     	when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
		TicketOutDto ticketOutDto = new TicketOutDto();
		when(modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);
		assertNotNull(ticketOutDto);
//		assertEquals(TicketStatus.Open, ticketOutDto.getTicketStatus());
		assertEquals(ticketOutDto, ticketService.createTicket(ticketInDto));
	}
	
	 @Test
	    public void testGetAllTickets() {
	     
	        UserDetails userDetails = new UserDetails();
	        Ticket ticket1 = new Ticket();
	        Ticket ticket2 = new Ticket();
	        List<Ticket> tickets = Arrays.asList(ticket1,ticket2);
	        Page<Ticket> ticketPage = new PageImpl<>(tickets);

	        when(userRepository.findByEmail(anyString())).thenReturn(userDetails);
	        
	        when(ticketRepository.findByUserDetails(any(), any())).thenReturn(ticketPage);
	        when(ticketRepository.findByUserDetails(any(UserDetails.class), any())).thenReturn(ticketPage);
	     
	        when(modelMapper.map(any(), eq(TicketOutDto.class))).thenReturn(new TicketOutDto());
	        List<TicketOutDto> result = ticketService.getAllTickets(0, 10, "test@example.com", "My Tickets", "All");
        
	        assertNotNull(result);
	        assertEquals(2, result.size());

	        verify(userRepository, times(1)).findByEmail(anyString());
	        verify(ticketRepository, times(1)).findByUserDetails(any(), any());
	        verify(modelMapper, times(2)).map(any(), eq(TicketOutDto.class));
	    }
	
	@Test
	public void testGetTicketById() {
		
	}
	
	
}
