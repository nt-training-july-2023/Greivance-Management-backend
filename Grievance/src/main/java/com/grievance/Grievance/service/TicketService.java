package com.grievance.Grievance.service;

import java.util.List;
import java.util.Optional;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;

public interface TicketService {

public TicketOutDto createTicket(TicketInDto tickdeTicketInDto);

public List<TicketOutDto> getAllTickets();

public TicketOutDto getTicketById(long ticketId);

public TicketOutDto updateTicket(TicketInDto ticketInDto, long ticketId);

public List<TicketOutDto>   getAllTicketsByDepartment(long deptId);

}
