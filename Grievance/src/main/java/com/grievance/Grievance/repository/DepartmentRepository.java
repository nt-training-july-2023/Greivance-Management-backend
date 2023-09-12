package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grievance.Grievance.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findBydeptName(String deptName);
}
