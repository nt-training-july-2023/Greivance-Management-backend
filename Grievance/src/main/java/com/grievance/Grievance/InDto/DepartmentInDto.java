package com.grievance.Grievance.InDto;

import javax.validation.constraints.NotEmpty;

/**
 * Represents the input data for creating a new department.
 */
public class DepartmentInDto {
	/**
	 * The name of the department.
	 */
	@NotEmpty(message = "Department name can not be empty")
	private String deptName;

	/**
	 * Gets the name of the department.
	 *
	 * @return The department name.
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the name of the department.
	 *
	 * @param deptName The department name.
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Constructs a new {@code DepartmentInDto} instance with the specified
	 * department name.
	 *
	 * @param deptName The department name.
	 */

	public DepartmentInDto(@NotEmpty(message = "Department name can not be empty") String deptName) {
		super();
		this.deptName = deptName;
	}

	/**
	 * Constructs a new, empty {@code DepartmentInDto} instance.
	 */
	public DepartmentInDto() {
		super();
	}

	/**
	 * Returns a string representation of the {@code DepartmentInDto} object.
	 *
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "DepartmentInDto [deptName=" + deptName + "]";
	}

}
