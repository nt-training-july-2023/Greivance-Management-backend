package com.grievance.Grievance.OutDto;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;

public class DepartmentOutDto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deptId;

	@NotNull
	private String deptName;

	private List<UserDetails> userDetails;

	private List<Ticket> tickets;

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
	public List<UserDetails> getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @param deptId
	 * @param deptName
	 * @param userDetails
	 * @param tickets
	 */
	public DepartmentOutDto(long deptId, @NotNull String deptName, List<UserDetails> userDetails,
			List<Ticket> tickets) {
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
