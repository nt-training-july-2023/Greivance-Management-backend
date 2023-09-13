package com.grievance.Grievance.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.service.TicketService;

import net.bytebuddy.asm.Advice.This;

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
	
	@Override
	public List<TicketOutDto> getAllTickets(){
		List<Ticket> tickets = this.ticketRepo.findAll();
		List<TicketOutDto> ticketList = tickets.stream().map(ticket -> this.ticketToTicketOutDto(ticket)).collect(Collectors.toList());
		return ticketList;
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
