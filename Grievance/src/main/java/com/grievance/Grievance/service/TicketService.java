package com.grievance.Grievance.service;

import java.util.List;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;

/**
 * The service methods in this interface are responsible for handling business.
 * logic related to tickets.
 */
public interface TicketService {

	/**
	 * Creates a new ticket based on the provided.
	 *
	 * @param ticketInDto The DTO containing ticket details to create.
	 * @return TicketOutDto.
	 */
	 TicketOutDto createTicket(TicketInDto ticketInDto);

	/**
	 * Retrieves a list of tickets.
	 *
	 * @param pageNumber   The page number to retrieve.
	 * @param pageSize     The number of tickets to retrieve per page.
	 * @param email        The email associated with the user.
	 * @param filter       Retrieve the data filter wise.
	 * @param type         Retrieve Type Ticket type wise.
	 * @return A list of ticketOutDtos.
	 */
	 List<TicketOutDto> getAllTickets(Integer pageNumber, Integer pageSize, String email, String filter,
			String type);

	/**
	 * Retrieves a ticket by its unique id (ticketId).
	 *
	 * @param ticketId The unique identifier of the ticket to retrieve.
	 * @return The ticketOutdto.
	 */
	 TicketOutDto getTicketById(long ticketId);

	/**
	 * Updates a ticket based on the provided.
	 *
	 * @param ticketUpdateDto The DTO containing ticket details to update.
	 * @param ticketId        The unique identifier of the ticket to update.
	 * @return Updated ticketOutDto.
	 */
	TicketOutDto updateTicket(TicketUpdateDto ticketUpdateDto, long ticketId);

}
