package com.grievance.Grievance.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.service.TicketService;

/**
 * Controller class for managing Ticket-related operations.
 */
@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class TicketController {

	@Autowired
	TicketService ticketService;
	/**
	 * Create a new ticket.
	 *
	 * @param ticketInDto for creating the ticket.
	 * @return ResponseEntity containing the created TicketOutDto.
	 */
	@PostMapping("/ticket")
	public ResponseEntity<TicketOutDto> createTicket(@Validated @RequestBody TicketInDto ticketInDto) {
		TicketOutDto ticketOutDto = ticketService.createTicket(ticketInDto);
		ResponseEntity ticketResponse = new ResponseEntity(ticketOutDto, HttpStatus.CREATED);
		return ticketResponse;
	}

	/**
	 * Get a list of all tickets based on filters like page number, page size,
	 * email, and ticket status.
	 *
	 * @param pageNumber   The page number for pagination.
	 * @param pageSize     The page size for pagination.
	 * @param email        The email address for filtering by user.
	 * @param ticketStatus The status for filtering.
	 * @return ResponseEntity containing a list of TicketOutDto objects.
	 */
	@GetMapping("/tickets")
	public ResponseEntity<List<TicketOutDto>> getAllTickets(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestHeader("email") String email, @RequestParam String type,@RequestParam String filter) {

		List<TicketOutDto> ticketOutDtos = ticketService.getAllTickets(pageNumber, pageSize, email, type ,filter);
		return ResponseEntity.ok(ticketOutDtos);
	}

	/**
	 * Get a ticket by its ID.
	 *
	 * @param ticketId The ID of the ticket to retrieve.
	 * @return ResponseEntity containing the TicketOutDto of the requested ticket.
	 */
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketOutDto> getTicketById(@PathVariable("ticketId") long ticketId) {
		TicketOutDto ticketOutDto = ticketService.getTicketById(ticketId);
		return ResponseEntity.ok(ticketOutDto);
	}

	/**
	 * Update a ticket by its ID.
	 *
	 * @param ticketUpdateDto for updating the ticket.
	 * @param ticketId        The ID of the ticket to update.
	 * @return ResponseEntity containing the updated TicketOutDto.
	 */
	@PutMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketOutDto> updateTicket(@RequestBody TicketUpdateDto ticketUpdateDto,
			@PathVariable("ticketId") long ticketId) {
		TicketOutDto ticketOutDto = ticketService.updateTicket(ticketUpdateDto, ticketId);
		return ResponseEntity.ok(ticketOutDto);
	}

}
