package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Comment;

public class TicketOutDtoTest {

private TicketOutDto ticketOutDto;
	
	@BeforeEach
	public void setUp() {
		ticketOutDto = new TicketOutDto();
		
		ticketOutDto.setTicketId(1);
		
		
		
		ticketOutDto.setComments(new ArrayList<Comment>());
		
		ticketOutDto.setDescription("abcd");
		ticketOutDto.setTicketId(1);
		ticketOutDto.setTicketTitle("Tech issue");
		ticketOutDto.setTicketType(TicketType.valueOf("Grievance"));
		
		
		ticketOutDto.setTicketStatus(TicketStatus.valueOf("Open"));
		
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		ticketOutDto.setDepartment(departmentOutDto);

        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();
      ticketOutDto.setUserDetails(userDetailsOutDto);
   
        
		
	}
	
	@Test
    public void testticketId() {
        assertEquals(1, ticketOutDto.getTicketId());
    }

	@Test
    public void testTitle() {
        assertEquals("Tech issue", ticketOutDto.getTicketTitle());
    }

	@Test
	public void testTicketType() {

		assertEquals(TicketType.valueOf("Grievance"), ticketOutDto.getTicketType());
	}

	@Test
	public void testTicketStatus() {

		assertEquals(TicketStatus.valueOf("Open"), ticketOutDto.getTicketStatus());
	}

	@Test
	public void testTicketDescription() {

		assertEquals("abcd", ticketOutDto.getDescription());
	}

	@Test
	public void testTicketDepartment() {

	
		assertNotNull(ticketOutDto);
	}

	@Test
	public void testTicketCommets() {

		assertEquals(new ArrayList<Comment>(), ticketOutDto.getComments());
	}

	@Test
	public void testUsers() {
		
		assertNotNull(ticketOutDto.getUserDetails());
	}


}
