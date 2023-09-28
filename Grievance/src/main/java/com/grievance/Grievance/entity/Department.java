package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents a department in the organization.
 */
@Entity
public class Department {

	/**
	 * The unique identifier for this department.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deptId;
	/**
	 * The name of the department (unique).
	 */
	@Column(name = "deptName", unique = true)
	private String deptName;
	/**
	 * The list of tickets associated with this department.
	 */
	@JsonManagedReference(value = "dep")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
	private List<Ticket> tickets;
	/**
	 * The list of user details associated with this department.
	 */
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
	private List<UserDetails> userDetails;

	/**
	 * Get the unique identifier for this department.
	 *
	 * @return The department's identifier.
	 */
	public long getDeptId() {
		return deptId;
	}

	/**
	 * Set the unique identifier for this department.
	 *
	 * @param deptId The department's identifier.
	 */
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	/**
	 * Get the name of the department.
	 *
	 * @return The department's name.
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Set the name of the department.
	 *
	 * @param deptName The department's name.
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Get the list of tickets associated with this department.
	 *
	 * @return The list of tickets.
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Set the list of tickets associated with this department.
	 *
	 * @param tickets The list of tickets.
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * Get the list of user details associated with this department.
	 *
	 * @return The list of user details.
	 */
	public List<UserDetails> getUserDetails() {
		return userDetails;
	}

	/**
	 * Set the list of user details associated with this department.
	 *
	 * @param userDetails The list of user details.
	 */
	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * Create a new instance of the Department class.
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "deptId=" + deptId + ", deptName=" + deptName + "";
	}

}