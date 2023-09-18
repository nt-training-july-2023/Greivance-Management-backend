package com.grievance.Grievance.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.service.TicketService;

@RestController
@RequestMapping("/grievance")
@CrossOrigin("*")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@PostMapping("/ticket")
	public ResponseEntity<TicketOutDto> createTicket(@Validated @RequestBody TicketInDto ticketInDto) {
		TicketOutDto ticketOutDto = ticketService.createTicket(ticketInDto);
		ResponseEntity ticketResponse = new ResponseEntity(ticketOutDto,HttpStatus.CREATED);
		return ticketResponse;
	}
	@GetMapping("/tickets")
	public ResponseEntity<List<TicketOutDto>> getAllTickets(){
		List<TicketOutDto> ticketOutDtos = ticketService.getAllTickets();
		return ResponseEntity.ok(ticketOutDtos);
	}
	
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketOutDto> getTicketById(@PathVariable ("ticketId") long ticketId){
		TicketOutDto ticketOutDto = ticketService.getTicketById(ticketId);
		return ResponseEntity.ok(ticketOutDto);
	}
	
	@PutMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketOutDto> updateTicket(@RequestBody TicketInDto ticketInDto ,@PathVariable ("ticketId") long ticketId ){
		TicketOutDto ticketOutDto = ticketService.updateTicket(ticketInDto, ticketId);
		return ResponseEntity.ok(ticketOutDto);
	}

}
