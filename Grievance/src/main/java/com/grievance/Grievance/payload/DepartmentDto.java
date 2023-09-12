package com.grievance.Grievance.payload;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class DepartmentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deptId;
	
	@NotNull
	private String deptName;
	/**
	 * 
	 */
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param deptId
	 * @param deptName
	 */
	public DepartmentDto(long deptId, String deptName) {
		super();
		this.deptId = deptId;
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
}
