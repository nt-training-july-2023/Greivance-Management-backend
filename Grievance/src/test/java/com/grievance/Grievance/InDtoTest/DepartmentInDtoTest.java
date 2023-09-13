package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.InDto.DepartmentInDto;

public class DepartmentInDtoTest {

	@Test
	public void testDeptName() {

		DepartmentInDto departmentInDto = new  DepartmentInDto();
		departmentInDto.setDeptName("IT");
		assertEquals("IT", departmentInDto.getDeptName());
	}
}
