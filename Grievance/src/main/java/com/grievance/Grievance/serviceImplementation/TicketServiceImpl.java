package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.exception.ResourceNotFoundException;
import com.grievance.Grievance.repository.CommentRepository;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public TicketOutDto createTicket(TicketInDto ticketInDto) {
		// TODO Auto-generated method stub

		Ticket ticket = this.modelMapper.map(ticketInDto, Ticket.class);
		ticket.setTicketStatus(TicketStatus.Open);
		Ticket savedTicket = ticketRepository.save(ticket);
		TicketOutDto ticketOutDto = this.modelMapper.map(savedTicket, TicketOutDto.class);
		return ticketOutDto;
	}

	@Override
	public List<TicketOutDto> getAllTickets(Integer pageNumber, Integer pageSize, TicketStatus ticketStatus) {
		// TODO Auto-generated method stub

		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("ticketStatus"));
		// GetAllByDepartment

		Page<Ticket> ticketsPage = ticketRepository.findAll(pageable);
		List<TicketOutDto> list = new ArrayList<TicketOutDto>();
		for (Ticket ticket : ticketsPage) {
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
	public TicketOutDto updateTicket(TicketUpdateDto ticketUpdateDto, long ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("", "a", ""));

		ticket.setTicketStatus(ticketUpdateDto.getTicketStatus());

		Comment comment = new Comment();
		comment.setContent(ticketUpdateDto.getContent());
		comment.setLastUpdatedAt(new Date());
		comment.setTicket(ticket);
		commentRepository.save(comment);
		ticket.getComments().add(comment);
		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(comment);
		ticket.setComments(commentList);

		Ticket savedTicket = ticketRepository.save(ticket);
		TicketOutDto ticketOutDto = modelMapper.map(savedTicket, TicketOutDto.class);
		return ticketOutDto;
	}

	@Override
	public List<TicketOutDto> getAllTicketsByDepartment(long deptId) {
		// TODO Auto-generated method stub
		return null;
	}
}
