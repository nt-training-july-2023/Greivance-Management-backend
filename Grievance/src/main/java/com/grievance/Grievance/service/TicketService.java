package com.grievance.Grievance.service;

import java.util.List;
import java.util.Optional;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;

public interface TicketService {

	public Optional<TicketOutDto> createTicket(TicketInDto ticketInDto);
	public List<TicketOutDto> getAllTickets();
	
}
