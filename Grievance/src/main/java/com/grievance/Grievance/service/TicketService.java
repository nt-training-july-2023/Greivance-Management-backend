package com.grievance.Grievance.service;

import java.util.List;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;

public interface TicketService {

	public TicketOutDto createTicket(TicketInDto tickdeTicketInDto);

	public List<TicketOutDto> getAllTickets(Integer pageNumber, Integer pageSize, TicketStatus ticketStatus);

	public TicketOutDto getTicketById(long ticketId);

	public TicketOutDto updateTicket(TicketUpdateDto ticketUpdateDto, long ticketId);

	public List<TicketOutDto> getAllTicketsByDepartment(long deptId);

}
