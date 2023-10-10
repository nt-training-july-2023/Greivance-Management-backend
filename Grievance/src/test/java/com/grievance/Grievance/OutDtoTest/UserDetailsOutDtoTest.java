package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.OutDto.CommentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;

public class UserDetailsOutDtoTest {

  private UserDetailsOutDto userDetailsOutDto;

  @BeforeEach
  public void setUp() {
    userDetailsOutDto = new UserDetailsOutDto();
    userDetailsOutDto.setId(1);
    userDetailsOutDto.setDepartment("IT");
    userDetailsOutDto.setName("Sneha");

    List<CommentOutDto> comments = new ArrayList<>();
    CommentOutDto comment1 = new CommentOutDto();
    CommentOutDto comment2 = new CommentOutDto();
    comments.add(comment1);
    comments.add(comment2);
    userDetailsOutDto.setComments(comments);

    userDetailsOutDto.setEmail("sneha@nucleusteq.com");
    userDetailsOutDto.setIsLoggedIn(false);

    List<TicketOutDto> tickets = new ArrayList<>();
    TicketOutDto ticket1 = new TicketOutDto();
    TicketOutDto ticket2 = new TicketOutDto();
    tickets.add(ticket1);
    tickets.add(ticket2);
    userDetailsOutDto.setTickets(tickets);

    userDetailsOutDto.setUserType(UserType.Member);
  }


  @Test
  public void testId() {
    assertEquals(1, userDetailsOutDto.getId());
  }

  @Test
  public void testDepartment() {

    assertEquals("IT", userDetailsOutDto.getDepartment());
  }

  @Test
  public void testName() {
    assertEquals("Sneha", userDetailsOutDto.getName());
  }

  @Test
  public void testComments() {
    List<CommentOutDto> comments = userDetailsOutDto.getComments();
    assertEquals(comments, userDetailsOutDto.getComments());

  }

  @Test
  public void testEmail() {
    assertEquals("sneha@nucleusteq.com",
        userDetailsOutDto.getEmail());
  }

  @Test
  public void testIsLoggedIn() {
    assertFalse(userDetailsOutDto.getIsLoggedIn());
  }

  @Test
  public void testTickets() {
    List<TicketOutDto> tickets = userDetailsOutDto.getTickets();
    assertEquals(tickets, userDetailsOutDto.getTickets());

  }

  @Test
  public void testUserType() {
    assertEquals(UserType.Member, userDetailsOutDto.getUserType());
  }

}
