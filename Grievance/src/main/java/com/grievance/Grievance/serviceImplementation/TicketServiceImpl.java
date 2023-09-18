package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public TicketOutDto createTicket(TicketInDto ticketInDto) {
		// TODO Auto-generated method stub
		System.out.println(ticketInDto.getComments());
		
		ticketInDto.setTicketStatus(TicketStatus.Open);
		System.out.println("status:" +ticketInDto.getDescription());
		Ticket ticket = this.modelMapper.map(ticketInDto, Ticket.class);
		System.out.println();
		Ticket savedTicket = ticketRepository.save(ticket);
		TicketOutDto ticketOutDto = this.modelMapper.map(savedTicket, TicketOutDto.class);
		return ticketOutDto;
	}

	@Override
	public List<TicketOutDto> getAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = ticketRepository.findAll();
		List<TicketOutDto> list = new ArrayList<TicketOutDto>();
		for(Ticket ticket :tickets) {
			list.add(this.modelMapper.map(ticket, TicketOutDto.class));		
		}
		return list;
	}

	@Override
	public TicketOutDto getTicketById(long ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(ticketId).get();
		TicketOutDto ticketOutDto = this.modelMapper.map(ticket, TicketOutDto.class);
		return ticketOutDto;
	}

	@Override
	public TicketOutDto updateTicket(TicketInDto ticketInDto, long ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(ticketId).get();
		 ticket.setTicketStatus(ticketInDto.getTicketStatus());	
		return null;
	}

	@Override
	public List<TicketOutDto> getAllTicketsByDepartment(long deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
