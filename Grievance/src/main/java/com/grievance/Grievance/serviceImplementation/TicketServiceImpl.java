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
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.RecordNotFoundException;
import com.grievance.Grievance.repository.CommentRepository;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.TicketService;

/**
 * Implementation of the TicketService interface providing operations related to
 * tickets.
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates a new ticket based on the provided TicketInDto.
	 *
	 * @param ticketInDto The DTO containing ticket information.
	 * @return The DTO representing the created ticket.
	 */
	@Override
	public TicketOutDto createTicket(TicketInDto ticketInDto) {
		// TODO Auto-generated method stub

		Ticket ticket = this.modelMapper.map(ticketInDto, Ticket.class);
		ticket.setTicketStatus(TicketStatus.Open);
		Ticket savedTicket = ticketRepository.save(ticket);
		TicketOutDto ticketOutDto = this.modelMapper.map(savedTicket, TicketOutDto.class);
		return ticketOutDto;
	}

	/**
	 * Retrieves a list of tickets with pagination and filtering options.
	 * 
	 * Ticket status -All, open ,Being_Addressed , Resolved.
	 * TicketFilter - All, My tickets , MyDepartment.(TicketWise and StatusWise)
	 *
	 * @param pageNumber   The page number.
	 * @param pageSize     The number of tickets per page.
	 * @param email        The user's email for filtering.
	 * @param ticketStatus The ticket status for filtering.
	 * @return A list of DTOs representing tickets.
	 */
	

	@Override
	public List<TicketOutDto> getAllTickets(Integer pageNumber, Integer pageSize, String email, String type,
			String filter) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		UserDetails userDetails = userRepository.findByEmail(email);
		Department department = userDetails.getDepartment();
		Page<Ticket> tickets = null;

		
		// For Admin
		 

		if (userDetails.getUsertype() == UserType.Admin) {
			// Admin
			// If Filter is Ticket wise.

			if (filter.equals("All")) {
				if (type.equals("My Tickets")) {
					tickets = ticketRepository.findByUserDetails(userDetails, pageable);
				} else if (type.equals("My Department")) {
					tickets = ticketRepository.findByDepartment(department, pageable);
				} else {
					tickets = ticketRepository.findAll(pageable);
				}
			} else {
				// If Filter is status wise.

				// Fetching the value of filter.
				TicketStatus ticketStatus = TicketStatus.valueOf(filter);
				if (type.equals("My Ticket")) {
					tickets = ticketRepository.findByUserDetailsAndTicketStatus(userDetails, ticketStatus, pageable);
				} else if (type.equals("My Department")) {
					tickets = ticketRepository.findByDepartmentAndTicketStatus(department, ticketStatus, pageable);
				} else {
					tickets = ticketRepository.findByTicketStatus(ticketStatus, pageable);
				}
			}

			List<TicketOutDto> list = new ArrayList<TicketOutDto>();
			for (Ticket ticket : tickets) {
				list.add(this.modelMapper.map(ticket, TicketOutDto.class));
			}
			return list;
			// Admin
		}

		// Member
		else {
			// Filter Ticket wise

			if (filter.equals("All")) {
				if (type.equals("My Tickets")) {
					tickets = ticketRepository.findByUserDetails(userDetails, pageable);
				} else if (type.equals("All")) {
					tickets = ticketRepository.findByUserDetailsOrDepartment(userDetails, department, pageable);
				} else {
					tickets = ticketRepository.findByDepartment(department, pageable);
				}
			}

			// Filter Status wise
			else {
				TicketStatus ticketStatus = TicketStatus.valueOf(filter);
				if (type.equals("My Tickets")) {
					tickets = ticketRepository.findByUserDetailsAndTicketStatus(userDetails, ticketStatus, pageable);
				} else if (type.equals("All")) {
					tickets = ticketRepository.findByTicketStatusAndDepartmentOrUserDetails(department, userDetails,
							ticketStatus, pageable);
				} else {
					tickets = ticketRepository.findByDepartmentAndTicketStatus(department, ticketStatus, pageable);
				}
			}

			List<TicketOutDto> outDtosList = new ArrayList<TicketOutDto>();
			for (Ticket ticket : tickets) {
				outDtosList.add(this.modelMapper.map(ticket, TicketOutDto.class));
			}
			return outDtosList;
		}
	}

	/**
	 * Retrieves a ticket by its unique identifier.
	 *
	 * @param ticketId The unique identifier of the ticket to retrieve.
	 * @return The DTO representing the retrieved ticket.
	 */
	@Override
	public TicketOutDto getTicketById(long ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(ticketId).get();
		if (ticket==null) {
			throw new RecordNotFoundException("Ticket with given Id not found");
		}
		TicketOutDto ticketOutDto = this.modelMapper.map(ticket, TicketOutDto.class);
		return ticketOutDto;
	}

	/**
	 * Updates a ticket's status and adds a comment.
	 *
	 * @param ticketUpdateDto The DTO containing ticket update information.
	 * @param ticketId        The unique identifier of the ticket to update.
	 * @return The DTO representing the updated ticket.
	 */
	@Override
	public TicketOutDto updateTicket(TicketUpdateDto ticketUpdateDto, long ticketId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketRepository.findById(ticketId).get();
		if (ticket==null) {
			throw new RecordNotFoundException("Ticket with given Id not found");
		}
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

	/**
	 * Retrieves a list of tickets by department.
	 *
	 * @param deptId The unique identifier of the department.
	 * @return A list of DTOs representing tickets.
	 */
	@Override
	public List<TicketOutDto> getAllTicketsByDepartment(long deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
