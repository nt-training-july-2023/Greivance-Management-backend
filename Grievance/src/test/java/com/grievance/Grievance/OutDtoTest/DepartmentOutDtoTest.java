package com.grievance.Grievance.OutDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.Grievance.OutDto.DepartmentOutDto;

public class DepartmentOutDtoTest {

	private DepartmentOutDto departmentOutDto;

	@BeforeEach
	public void setUp() {
		departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
	}

	@Test
	public void testDeptName() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		assertEquals("IT", departmentOutDto.getDeptName());
	}

	@Test
	public void testDeptId() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
		assertEquals(1, departmentOutDto.getDeptId());
	}

	@Test
	public void testDeptTickets() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
	}

	@Test
	public void testDeptUser() {
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		departmentOutDto.setDeptId(1);
		departmentOutDto.setDeptName("IT");
	}

}
