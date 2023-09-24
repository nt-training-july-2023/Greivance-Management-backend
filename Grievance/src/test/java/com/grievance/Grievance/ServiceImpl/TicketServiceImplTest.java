package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.serviceImplementation.TicketServiceImpl;


@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private TicketRepository ticketRepository;
	
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
		ticket.setTicketStatus(TicketStatus.Open);
		ticket.setTicketTitle("Technical Issue");
		ticket.setTicketType(TicketType.Grievance);
		ticket.setUserDetails(new UserDetails());
			
		when(modelMapper.map(ticketInDto, Ticket.class)).thenReturn(ticket);
     	when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
		TicketOutDto ticketOutDto = new TicketOutDto();
		when(modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);
		assertNotNull(ticketOutDto);
		assertEquals(TicketStatus.Open, ticketOutDto.getTicketStatus());
		assertEquals(ticketOutDto, ticketService.createTicket(ticketInDto));
	}
	
	@Test
	public void testGetAllTickets() {
		
		List<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        tickets.add(ticket1);
        tickets.add(ticket2);
        
        List<TicketOutDto> ticketOutDtos = new ArrayList<>();
        TicketOutDto ticketOutDto1 = new TicketOutDto();
        TicketOutDto ticketOutDto2 = new TicketOutDto();
        ticketOutDtos.add(ticketOutDto1);
        ticketOutDtos.add(ticketOutDto2);
        
        when(ticketRepository.findAll()).thenReturn(tickets);
        
        when(modelMapper.map(ticket1, TicketOutDto.class)).thenReturn(ticketOutDto1);
        when(modelMapper.map(ticket2, TicketOutDto.class)).thenReturn(ticketOutDto2);
        
//        List<TicketOutDto> result = ticketService.getAllTickets();
//        assertNotNull(result);
        verify(ticketRepository).findAll();
	}
	
	
	
}
