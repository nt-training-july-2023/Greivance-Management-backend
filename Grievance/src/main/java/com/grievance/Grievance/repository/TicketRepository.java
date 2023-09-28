package com.grievance.Grievance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

      Page<Ticket> findByDepartment(Department department, Pageable pageable);
   
      Page<Ticket> findByUserDetails(UserDetails userDetails, Pageable pageable);
	
      Page<Ticket> findByUserDetailsAndTicketStatus(UserDetails userDetails, TicketStatus ticketStatus ,Pageable pageable);
	
      Page<Ticket> findByTicketStatus(TicketStatus ticketStatus, Pageable pageable);
	  
      Page<Ticket> findByDepartmentAndTicketStatus(Department department, TicketStatus ticketStatus, Pageable pageable);
	  
      Page<Ticket> findByUserDetailsAndDepartment(UserDetails userDetails, Department department, Pageable pageable);
	
      Page<Ticket> findByDepartmentAndUserDetailsAndTicketStatus(Department department,UserDetails userDetails,TicketStatus ticketStatus,Pageable pageable);
	  
      Page<Ticket> findByTicketStatusAndDepartmentOrUserDetails(Department department,UserDetails userDetails,TicketStatus ticketStatus,Pageable pageable);
	
      Page<Ticket> findByUserDetailsOrDepartment(UserDetails userDetails,Department department,Pageable pageable);


}
