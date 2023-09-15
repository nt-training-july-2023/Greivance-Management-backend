package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
		
		Ticket ticket = new Ticket();
		ticket.setDepartment(new Department());
		ticket.setDescription("abcd");
		ticket.setTicketId(1);
		ticket.setTicketStatus(TicketStatus.valueOf("OPEN"));
		ticket.setTicketTitle("Technical Issue");
		ticket.setTicketType(TicketType.valueOf("GRIEVANCE"));
		ticket.setUserDetails(new UserDetails());
		
		TicketInDto ticketInDto = new TicketInDto();
		TicketOutDto ticketOutDto = new TicketOutDto();
		
		when(modelMapper.map(ticketInDto, Ticket.class)).thenReturn(ticket);
		when(ticketRepository.save(ticket)).thenReturn(ticket);
		when(modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);
		assertEquals(Optional.of(ticketOutDto), ticketService.createTicket(ticketInDto));
		
		
		
	}
	
	
	
}
