package com.grievance.Grievance.serviceImplementation;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;
	

	@Autowired
	private ModelMapper modelMapper;

	// Create ticket API

	@Override
	public Optional<TicketOutDto> createTicket(TicketInDto ticketInDto) {

		Ticket ticket = this.ticketInDtoToTicket(ticketInDto);
		Ticket savedTicket = this.ticketRepo.save(ticket);
		return Optional.ofNullable(this.ticketToTicketOutDto(savedTicket));
	}

	// TicketInDto to Ticket.

	public Ticket ticketInDtoToTicket(TicketInDto ticketInDto) {
		Ticket ticket = this.modelMapper.map(ticketInDto, Ticket.class);
		return ticket;

	}

	// Ticket to TicketOutDto.

	public TicketOutDto ticketToTicketOutDto(Ticket ticket) {

		TicketOutDto ticketOutDto = this.modelMapper.map(ticket, TicketOutDto.class);
		return ticketOutDto;
	}

}
