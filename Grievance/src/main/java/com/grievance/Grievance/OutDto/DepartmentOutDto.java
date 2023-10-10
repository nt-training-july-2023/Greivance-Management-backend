package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.entity.Ticket;

public class DepartmentOutDto {

	private long deptId;
	private String deptName;
	
	@JsonManagedReference
	private List<UserDetailsOutDto> userDetails;
	
	@JsonManagedReference(value = "dep")
//	private List<Ticket> tickets;
	private List<TicketOutDto> tickets;

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<UserDetailsOutDto> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetailsOutDto> userDetails) {
		this.userDetails = userDetails;
	}

	public List<TicketOutDto> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketOutDto> tickets) {
		this.tickets = tickets;
	}

	public DepartmentOutDto(long deptId, String deptName, List<UserDetailsOutDto> userDetails, List<TicketOutDto> tickets) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.userDetails = userDetails;
		this.tickets = tickets;
	}

	public DepartmentOutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DepartmentOutDto [deptName=" + deptName + "]";
	}
	
	
}
