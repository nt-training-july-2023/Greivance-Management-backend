package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket , Long>{

}
