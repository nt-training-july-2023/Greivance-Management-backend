package com.grievance.Grievance.InDto;

import javax.validation.constraints.NotEmpty;

public class DepartmentInDto {
	
	@NotEmpty
	private String deptName;

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
	 * 
	 */
	public DepartmentInDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
