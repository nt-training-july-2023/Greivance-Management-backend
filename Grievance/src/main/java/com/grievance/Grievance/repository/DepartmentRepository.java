package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.entity.Department;
/**
 * It provides CRUD (Create, Read, Update, Delete) operations for Department entity.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Department findBydeptName(String deptName);

}
