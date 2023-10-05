package com.grievance.Grievance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

/**
 * Repository interface for performing database operations on the Ticket entity.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	/**
	 * Find tickets by department with pagination.
	 *
	 * @param department The department to filter by.
	 * @param pageable   The pagination information.
	 * @return A page of tickets belonging to the specified department.
	 */
	Page<Ticket> findByDepartment(Department department, Pageable pageable);

	/**
	 * Find tickets by user details with pagination.
	 *
	 * @param userDetails The user details to filter by.
	 * @param pageable    The pagination information.
	 * @return A page of tickets associated with the specified user details.
	 */
	Page<Ticket> findByUserDetails(UserDetails userDetails, Pageable pageable);

	/**
	 * Find tickets by user details and ticket status with pagination.
	 *
	 * @param userDetails  The user details to filter by.
	 * @param ticketStatus The ticket status to filter by.
	 * @param pageable     The pagination information.
	 * @return A page of tickets matching the specified user details and ticket
	 *         status.
	 */
	Page<Ticket> findByUserDetailsAndTicketStatus(UserDetails userDetails, TicketStatus ticketStatus,
			Pageable pageable);

	/**
	 * Find tickets by user details and ticket status with pagination.
	 *
	 * @param ticketStatus The ticket status to filter by.
	 * @param pageable     The pagination information.
	 * @return A page of tickets matching the specified user details and ticket
	 *         status.
	 */
	Page<Ticket> findByTicketStatus(TicketStatus ticketStatus, Pageable pageable);

	/**
	 * Find tickets by department and ticket status with pagination.
	 *
	 * @param department   The department to filter by.
	 * @param ticketStatus The ticket status to filter by.
	 * @param pageable     The pagination information.
	 * @return A page of tickets matching the specified department and ticket
	 *         status.
	 */
	Page<Ticket> findByDepartmentAndTicketStatus(Department department, TicketStatus ticketStatus, Pageable pageable);

	/**
	 * Find tickets by user details and department with pagination.
	 *
	 * @param userDetails The user details to filter by.
	 * @param department  The department to filter by.
	 * @param pageable    The pagination information.
	 * @return A page of tickets matching the specified user details and department.
	 */
	Page<Ticket> findByUserDetailsAndDepartment(UserDetails userDetails, Department department, Pageable pageable);

	/**
	 * Find tickets by department, user details, and ticket status with pagination.
	 *
	 * @param department   The department to filter by.
	 * @param userDetails  The user details to filter by.
	 * @param ticketStatus The ticket status to filter by.
	 * @param pageable     The pagination information.
	 * @return A page of tickets matching the specified department, user details,
	 *         and ticket status.
	 */
	Page<Ticket> findByDepartmentAndUserDetailsAndTicketStatus(Department department, UserDetails userDetails,
			TicketStatus ticketStatus, Pageable pageable);

	/**
	 * Find tickets by ticket status, department, or user details with pagination.
	 *
	 * @param department   The department to filter by.
	 * @param userDetails  The user details to filter by.
	 * @param ticketStatus The ticket status to filter by.
	 * @param pageable     The pagination information.
	 * @return A page of tickets matching the specified department, user details, or
	 *         ticket status.
	 */
	Page<Ticket> findByTicketStatusAndDepartmentOrUserDetails(Department department, UserDetails userDetails,
			TicketStatus ticketStatus, Pageable pageable);

	/**
	 * Find tickets by user details or department with pagination.
	 *
	 * @param userDetails The user details to filter by.
	 * @param department  The department to filter by.
	 * @param pageable    The pagination information.
	 * @return A page of tickets matching the specified user details or department.
	 */

	Page<Ticket> findByUserDetailsOrDepartment(UserDetails userDetails, Department department, Pageable pageable);

}
