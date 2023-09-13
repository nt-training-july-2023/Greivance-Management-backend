package com.grievance.Grievance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.service.TicketService;
import com.grievance.Grievance.serviceImplementation.TicketServiceImpl;

@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class TicketController {

	@Autowired
	TicketService ticketService;

	// Create new Ticket API.

	@PostMapping("/saveTicket")
	public ResponseEntity<TicketOutDto> createTicket(@Validated @RequestBody TicketInDto ticketInDto) {
		Optional<TicketOutDto> savedTicketOutDto = this.ticketService.createTicket(ticketInDto);
		return new ResponseEntity(savedTicketOutDto, HttpStatus.CREATED);
	}
	
	// Get All Tickets
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<TicketOutDto>> getAllTickets(){
		List<TicketOutDto> ticketOutDtosList = this.ticketService.getAllTickets();
		return ResponseEntity.ok(ticketOutDtosList);
	}

}
