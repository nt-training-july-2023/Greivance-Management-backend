package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Department {

	@NotNull
	private String deptName;

	// One department have List of users.
	// Department is the parent entity if dept deletes it's users also get deleted

	@OneToMany(mappedBy = "department")
//	 @JoinColumn(name = "Id")
	private List<UserDetails> userDetails;

	@OneToMany(mappedBy = "department")
//	 @JoinColumn(name = "ticketId")
	private List<Ticket> tickets;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deptId;

	/**
	 * 
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param deptName
	 * @param deptId
	 */
	public Department(String deptName, long deptId) {
		super();
		this.deptName = deptName;
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
}
