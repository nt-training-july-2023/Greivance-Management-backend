package com.grievance.Grievance.InDto;

import javax.validation.constraints.NotEmpty;

public class DepartmentInDto {

	@NotEmpty(message = "Department name can not be empty")
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public DepartmentInDto(@NotEmpty(message = "Department name can not be empty") String deptName) {
		super();
		this.deptName = deptName;
	}

	public DepartmentInDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DepartmentInDto [deptName=" + deptName + "]";
	}

}
