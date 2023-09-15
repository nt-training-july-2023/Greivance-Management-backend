package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deptId;
	
	@NotEmpty
//	@JsonManagedReference
	private String deptName;
	
	@JsonManagedReference(value = "depar")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department", fetch = FetchType.LAZY)
	private List<Ticket> tickets;
	
	@JsonManagedReference 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department", fetch = FetchType.LAZY)
	private List<UserDetails> userDetails;

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
	 * @param deptId
	 * @param deptName
	 * @param tickets
	 * @param userDetails
	 */
	public Department(long deptId, @NotEmpty String deptName, List<Ticket> tickets, List<UserDetails> userDetails) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.tickets = tickets;
		this.userDetails = userDetails;
	}

	/**
	 * 
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return deptName;
	}
	
	
	
	
}