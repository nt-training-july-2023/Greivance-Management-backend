package com.grievance.Grievance.InDtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.InDto.DepartmentInDto;

public class DepartmentInDtoTest {

	@Test
	public void testDeptName() {

		DepartmentInDto departmentInDto = new  DepartmentInDto();
		departmentInDto.setDeptName("IT");
		assertEquals("IT", departmentInDto.getDeptName());
	}
	@Test
    public void testDepartmentInDtoConstructor_Valid() {
	
	DepartmentInDto departmentInDto = new DepartmentInDto("HR");
	 assertNotNull(departmentInDto);
	 assertEquals("HR", departmentInDto.getDeptName());

	}
	@Test
    public void testToString() {
      
        DepartmentInDto departmentInDto = new DepartmentInDto("HR");
        String toStringResult = departmentInDto.toString();
        assertEquals("DepartmentInDto [deptName=HR]", toStringResult);
    }
}
