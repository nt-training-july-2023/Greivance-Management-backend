package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.controller.DepartmentController;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.TicketServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

	@Mock
	private TicketRepository ticketRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private TicketServiceImpl ticketService;
	
//	    @Test
//	    public void testCreateTicket_Returns_TicketObject() {
//	  
//	    	
//	    	Department department = new Department();
//	        department.setDeptId(1);
//	        department.setDeptName("SampleDept");
//
//	        UserDetails userDetails = new UserDetails();  
//	        userDetails.setUserId(1);
//	        userDetails.setName("SampleUser");
//
//	        TicketInDto ticketInDto = new TicketInDto();
//	        ticketInDto.setDepartment(department);
//	        ticketInDto.setUserDetails(userDetails);
//	       
//	        Ticket savedTicket = new Ticket();
//	        savedTicket.setDepartment(department);
//	        savedTicket.setUserDetails(userDetails);
//	        savedTicket.setDescription("SampleDescription");
//	       
//	        when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(department));
//	        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userDetails));
//	        when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);
//
//	        TicketOutDto ticketOutDto = ticketService.createTicket(ticketInDto);
//
//	        assertEquals("SampleDept", ticketOutDto.getDeptName());
//	        assertEquals("SampleUser", ticketOutDto.getName());
////	        assertEquals(1, ticketOutDto.getDeptId()); 
////	        assertEquals(1, ticketOutDto.getTicketId());
//	        assertEquals("SampleDescription", ticketOutDto.getDescription());
//	      
//	        verify(ticketRepository, times(1)).save(any(Ticket.class));
//	    }
	
//	@Test
//	public void testCreateTicket_Returns1_TicketObject() {
//
//		TicketInDto ticketInDto = new TicketInDto();
//
//		ticketInDto.setDepartment(new Department());
//		ticketInDto.setTicketStatus(TicketStatus.Open);
//		ticketInDto.setDescription("abcd");
//		ticketInDto.setTicketTitle("Technical Issue");
//		ticketInDto.setTicketType(TicketType.Grievance);
//		ticketInDto.setUserDetails(new UserDetails());
//		Department department = new Department();
//		department.setDeptId(1);
//		department.setDeptName("Department");
//
//		UserDetails userDetails = new UserDetails();
//		userDetails.setUserId(1);
//		userDetails.setName("User");
//
//		Ticket savedTicket = new Ticket();
//		savedTicket.setTicketId(1);
//		savedTicket.setTicketTitle("Technical Issue");
//		savedTicket.setTicketType(TicketType.Grievance);
//		savedTicket.setDescription("abcd");
//		savedTicket.setUserDetails(userDetails);
//		savedTicket.setDepartment(department);
//		savedTicket.setTicketStatus(TicketStatus.Open);
//
//		when(departmentRepository.findById(ticketInDto.getDepartment().getDeptId()))
//				.thenReturn(Optional.of(department));
//		when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(department));
//
//		// Mock userRepository
//		when(userRepository.findById(anyLong())).thenReturn(Optional.of(userDetails));
//
//		// Mock ticketRepository
//		when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);
//		when(userRepository.findById(ticketInDto.getUserDetails().getUserId())).thenReturn(Optional.of(userDetails));
//		when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);
//		TicketOutDto ticketOutDto = ticketService.createTicket(ticketInDto);
//
//		assertEquals(1, ticketOutDto.getTicketId());
//		assertEquals("Department", ticketOutDto.getDeptName());
//		assertEquals("User", ticketOutDto.getName());
//		assertEquals("abcd", ticketOutDto.getDescription());
//		assertEquals(TicketStatus.Open, ticketOutDto.getTicketStatus());
//		assertEquals("Technical Issue", ticketOutDto.getTicketTitle());
//		assertEquals(TicketType.Grievance, ticketOutDto.getTicketType());
//		assertNotNull(ticketOutDto.getUpdatedAt());
//		assertNotNull(ticketOutDto.getCreatedAt());
//		
//		verify(ticketRepository, times(1)).save(any(Ticket.class));
//	}
//	
	
	@Test
	public void testGetTicketById_ReturnsTicketObject() {
	  
		
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("dept");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setName("sneha");
		
	    Ticket ticket = new Ticket();
	    ticket.setTicketId(1);
	    ticket.setTicketTitle("SampleTicket");
	    ticket.setDepartment(department);
	    ticket.setUserDetails(userDetails);
	   
	    when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

	 
	    TicketOutDto ticketOutDto = ticketService.getTicketById(1L);

	 
	    assertEquals(1, ticketOutDto.getTicketId());
	    assertEquals("SampleTicket", ticketOutDto.getTicketTitle());
	   
	    verify(ticketRepository, times(1)).findById(1L);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//    public void testGetTicketById_ExistingTicket_ReturnsTicketOutDto() {
//      
//		Department department = new Department();
//		department.setDeptId(1);
//		department.setDeptName("dept");
//		department.setTickets(new ArrayList<Ticket>());
//		department.setUserDetails(new ArrayList<UserDetails>());
//		
//		Us
//		
//        Ticket sampleTicket = new Ticket();
//        sampleTicket.setTicketId(1L);
//        sampleTicket.setTicketTitle("Ticket");
//        sampleTicket.setDepartment(department);
//        
//        
//        when(ticketRepository.findById(1L)).thenReturn(Optional.of(sampleTicket));
//
//      
//        TicketOutDto ticketOutDto = ticketService.getTicketById(1L);
//
//      
//        assertEquals("Ticket", ticketOutDto.getTicketTitle());
//       
//    }

//    @Test
//    public void testGetTicketById_NonExistingTicket_ThrowsRecordNotFoundException() {
//    	long ticketId = 1L;
//        when(ticketRepository.findById(1L)).thenReturn(Optional.empty());
//        assertThrows(NoSuchElementException.class, () -> {
//            ticketService.getTicketById(ticketId);
//        });
//        ticketService.getTicketById(1L);
//    }
//

//	 @Test
//	    public void testGetAllTickets() {
//	     
//	        UserDetails userDetails = new UserDetails();
//	        Ticket ticket1 = new Ticket();
//	        Ticket ticket2 = new Ticket();
//	        List<Ticket> tickets = Arrays.asList(ticket1,ticket2);
//	        Page<Ticket> ticketPage = new PageImpl<>(tickets);
//
//	        when(userRepository.findByEmail(anyString())).thenReturn(userDetails);
//	        
//	        when(ticketRepository.findByUserDetails(any(), any())).thenReturn(ticketPage);
//	        when(ticketRepository.findByUserDetails(any(UserDetails.class), any())).thenReturn(ticketPage);
//	     
//	        when(modelMapper.map(any(), eq(TicketOutDto.class))).thenReturn(new TicketOutDto());
//	        List<TicketOutDto> result = ticketService.getAllTickets(0, 10, "test@example.com", "My Tickets", "All");
//        
//	        assertNotNull(result);
//	        assertEquals(2, result.size());
//
//	        verify(userRepository, times(1)).findByEmail(anyString());
//	        verify(ticketRepository, times(1)).findByUserDetails(any(), any());
//	        verify(modelMapper, times(2)).map(any(), eq(TicketOutDto.class));
//	    }
}


