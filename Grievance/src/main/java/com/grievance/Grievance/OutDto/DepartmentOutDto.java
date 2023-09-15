package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class DepartmentOutDto {

	private long deptId;
	private String deptName;

//	@JsonManagedReference
	private List<UserDetailsOutDto> userDetails;

	@JsonManagedReference
	private List<TicketOutDto> tickets;

	/**
	 * @return the deptId
	 */
	public long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the userDetails
	 */
	public List<UserDetailsOutDto> getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(List<UserDetailsOutDto> userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the tickets
	 */
	public List<TicketOutDto> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<TicketOutDto> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @param deptId
	 * @param deptName
	 * @param userDetails
	 * @param tickets
	 */
	public DepartmentOutDto(long deptId, String deptName, List<UserDetailsOutDto> userDetails, List<TicketOutDto> tickets) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.userDetails = userDetails;
		this.tickets = tickets;
	}

	/**
	 * 
	 */
	public DepartmentOutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
