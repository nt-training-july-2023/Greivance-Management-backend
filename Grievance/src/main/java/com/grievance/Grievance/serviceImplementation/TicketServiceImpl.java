package com.grievance.Grievance.serviceImplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grievance.Grievance.Constants.ValidationErrors;
import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.DepartmentOutDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.OutDto.UserDetailsOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.exception.RecordNotFoundException;
import com.grievance.Grievance.repository.CommentRepository;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.service.TicketService;

/**
 * Implementation of the TicketService interface providing operations related to
 * tickets.
 */
@Service
public class TicketServiceImpl implements TicketService {

  /**
   * Logger initialization.
   */
  private static final Logger LOGGER = LogManager
      .getLogger(TicketServiceImpl.class);
  /**
   * Auto wired Ticket Repository.
   */
  @Autowired
  private TicketRepository ticketRepository;

  /**
   * Auto wired DepartmentRepository.
   */
  @Autowired
  private DepartmentRepository departmentRepository;

  /**
   * Auto wired CommentRepository.
   */
  @Autowired
  private CommentRepository commentRepository;

  /**
   * Auto wired UserRepository.
   */
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

    Department department = departmentRepository
        .findById(ticketInDto.getDepartment().getDeptId())
        .orElseThrow(() -> new RecordNotFoundException(
            ValidationErrors.DEPARTMENT_NOT_FOUND_ERROR));
    UserDetails userDetails = userRepository
        .findById(ticketInDto.getUserDetails().getUserId())
        .orElseThrow(() -> new RecordNotFoundException(
            ValidationErrors.USER_NOT_FOUND_ERROR));

    Ticket ticket = new Ticket();
    ticket.setTicketTitle(ticketInDto.getTicketTitle());
    ticket.setTicketType(ticketInDto.getTicketType());
    ticket.setDescription(ticketInDto.getDescription());
    ticket.setUserDetails(userDetails);
    ticket.setDepartment(department);
    ticket.setTicketStatus(TicketStatus.Open);

    ticketRepository.save(ticket);

    TicketOutDto ticketOutDto = new TicketOutDto();
    ticketOutDto.setTicketId(ticket.getTicketId());
    ticketOutDto.setDeptName(ticket.getDepartment().getDeptName());
    ticketOutDto.setName(ticket.getUserDetails().getName());
    ticketOutDto.setDescription(ticket.getDescription());
    ticketOutDto.setTicketStatus(ticket.getTicketStatus());
    ticketOutDto.setTicketTitle(ticket.getTicketTitle());
    ticketOutDto.setTicketType(ticket.getTicketType());
    ticketOutDto.setUpdatedAt(ticket.getUpdatedAt());
    ticketOutDto.setCreatedAt(ticket.getCreatedAt());

    return ticketOutDto;
  }

  /**
   * Retrieves a list of tickets with pagination and filtering options. Ticket
   * status All, open ,Being_Addressed , Resolved. TicketFilter - All, My tickets
   * , MyDepartment.(TicketWise and StatusWise)
   *
   * @param pageNumber The page number.
   * @param pageSize   The number of tickets per page.
   * @param email      The user's email for filtering.
   * @return A list of DTOs representing tickets.
   */

  @Override
  public List<TicketOutDto> getAllTickets(Integer pageNumber,
      Integer pageSize, String email, String type, String filter) {
    // TODO Auto-generated method stub
    Sort sort = Sort.by("ticketStatus");
    Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
    UserDetails userDetails = userRepository.findByEmail(email);
    Department department = userDetails.getDepartment();
    Page<Ticket> tickets = null;

    if (userDetails.getUsertype() == UserType.Admin) {
      if (filter.equals("All")) {
        if (type.equals("My Tickets")) {
          tickets = ticketRepository.findByUserDetails(userDetails,
              pageable);
        } else if (type.equals("My Department")) {
          tickets = ticketRepository.findByDepartment(department,
              pageable);
        } else {
          tickets = ticketRepository.findAll(pageable);
        }
      } else {
        TicketStatus ticketStatus = TicketStatus.valueOf(filter);
        if (type.equals("My Tickets")) {
          tickets = ticketRepository.findByUserDetailsAndTicketStatus(
              userDetails, ticketStatus, pageable);
        } else if (type.equals("My Department")) {
          tickets = ticketRepository.findByDepartmentAndTicketStatus(
              department, ticketStatus, pageable);
        } else {
          tickets = ticketRepository.findByTicketStatus(ticketStatus,
              pageable);
        }
      }

      List<TicketOutDto> outDtosList = new ArrayList<TicketOutDto>();

      for (Ticket ticket : tickets) {
        TicketOutDto ticketOutDto = new TicketOutDto();

        DepartmentOutDto departmentOutDto = new DepartmentOutDto();
        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();

        ticketOutDto.setTicketId(ticket.getTicketId());
        ticketOutDto.setName(ticket.getUserDetails().getName());
        ticketOutDto
            .setDeptName(ticket.getDepartment().getDeptName());
        ticketOutDto.setTicketTitle(ticket.getTicketTitle());
        ticketOutDto.setTicketType(ticket.getTicketType());
        ticketOutDto.setTicketStatus(ticket.getTicketStatus());
        ticketOutDto.setDepartment(departmentOutDto);
        ticketOutDto.setUserDetails(userDetailsOutDto);
        ticketOutDto.setUpdatedAt(ticket.getUpdatedAt());
        ticketOutDto.setComments(ticket.getComments());
        outDtosList.add(ticketOutDto);
      }
      return outDtosList;

    } else {
      if (filter.equals("All")) {
        if (type.equals("My Tickets")) {
          tickets = ticketRepository.findByUserDetails(userDetails,
              pageable);
        } else if (type.equals("All")) {
          tickets = ticketRepository.findByUserDetailsOrDepartment(
              userDetails, department, pageable);
        } else {
          tickets = ticketRepository.findByDepartment(department,
              pageable);
        }
      } else {
        TicketStatus ticketStatus = TicketStatus.valueOf(filter);
        if (type.equals("My Tickets")) {
          tickets = ticketRepository.findByUserDetailsAndTicketStatus(
              userDetails, ticketStatus, pageable);
        } else if (type.equals("All")) {
          tickets = ticketRepository
              .findByTicketStatusAndDepartmentOrUserDetails(
                  department, userDetails, ticketStatus, pageable);
        } else {
          tickets = ticketRepository.findByDepartmentAndTicketStatus(
              department, ticketStatus, pageable);
        }
      }
      List<TicketOutDto> outDtosList = new ArrayList<TicketOutDto>();
      for (Ticket ticket : tickets) {
        TicketOutDto ticketOutDto = new TicketOutDto();
        DepartmentOutDto departmentOutDto = new DepartmentOutDto();
        UserDetailsOutDto userDetailsOutDto = new UserDetailsOutDto();

        ticketOutDto.setTicketId(ticket.getTicketId());
        ticketOutDto.setName(ticket.getUserDetails().getName());
        ticketOutDto
            .setDeptName(ticket.getDepartment().getDeptName());
        ticketOutDto.setTicketTitle(ticket.getTicketTitle());
        ticketOutDto.setTicketType(ticket.getTicketType());
        ticketOutDto.setTicketStatus(ticket.getTicketStatus());
        ticketOutDto.setDepartment(departmentOutDto);
        ticketOutDto.setUserDetails(userDetailsOutDto);
        ticketOutDto.setComments(ticket.getComments());
        ticketOutDto.setUpdatedAt(ticket.getUpdatedAt());
        outDtosList.add(ticketOutDto);
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
    LOGGER.error("Ticket with given Id not found");
    Ticket ticket = ticketRepository.findById(ticketId)
        .orElseThrow(() -> new RecordNotFoundException(
            ValidationErrors.TICKET_NOT_FOUND_ERROR));
    TicketOutDto ticketOutDto = new TicketOutDto();
    ticketOutDto.setTicketId(ticket.getTicketId());
    ticketOutDto.setTicketTitle(ticket.getTicketTitle());
    ticketOutDto.setDescription(ticket.getDescription());
    ticketOutDto.setDeptName(ticket.getDepartment().getDeptName());
    ticketOutDto.setTicketType(ticket.getTicketType());
    ticketOutDto.setTicketStatus(ticket.getTicketStatus());
    ticketOutDto.setName(ticket.getUserDetails().getName());
    ticketOutDto.setCreatedAt(ticket.getCreatedAt());
    ticketOutDto.setUpdatedAt(ticket.getUpdatedAt());
    ticketOutDto.setComments(ticket.getComments());
    ticketOutDto.setDeptId(ticket.getDepartment().getDeptId());
    ticketOutDto.setUserId(ticket.getUserDetails().getUserId());

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
  public TicketOutDto updateTicket(TicketUpdateDto ticketUpdateDto,
      long ticketId) {
    UserDetails userDetails = userRepository
        .findById(ticketUpdateDto.getUserId()).get();
    if (ticketUpdateDto.getTicketStatus().toString()
        .equals("Resolved")) {
      if (ticketUpdateDto.getContent().toString().equals("")) {
        return null;
      }
    }
    Ticket existingTicket = ticketRepository.findById(ticketId)
        .orElseThrow(() -> new RecordNotFoundException(
            ValidationErrors.TICKET_NOT_FOUND_ERROR));
    LOGGER.error("Ticket with given Id not found");
    existingTicket.setTicketStatus(ticketUpdateDto.getTicketStatus());
    Comment comment = new Comment();
    comment.setContent(ticketUpdateDto.getContent());
    comment.setLastUpdatedAt(new Date());
    comment.setTicket(existingTicket);
    comment.setMemberName(userDetails.getName());
    commentRepository.save(comment);

    existingTicket.getComments().add(comment);
    List<Comment> commentList = new ArrayList<Comment>();
    commentList.add(comment);
    existingTicket.setComments(commentList);
    existingTicket.setUpdatedAt(new Date());
    ticketRepository.save(existingTicket);

    TicketOutDto ticketOutDto = new TicketOutDto();
    ticketOutDto.setName(userDetails.getName());
    ticketOutDto
        .setDeptName(userDetails.getDepartment().getDeptName());
    ticketOutDto.setTicketType(existingTicket.getTicketType());
    ticketOutDto.setTicketStatus(existingTicket.getTicketStatus());
    ticketOutDto.setTicketTitle(existingTicket.getTicketTitle());
    ticketOutDto.setDescription(existingTicket.getDescription());
    ticketOutDto.setCreatedAt(existingTicket.getCreatedAt());
    ticketOutDto.setUpdatedAt(existingTicket.getUpdatedAt());
    ticketOutDto
        .setDeptId(existingTicket.getDepartment().getDeptId());
    ticketOutDto
        .setUserId(existingTicket.getUserDetails().getUserId());
    ticketOutDto.setComments(commentList);
    return ticketOutDto;
  }

}
