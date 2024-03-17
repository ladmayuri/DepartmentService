package com.example.DepartmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DepartmentService.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDeptId(Long deptId);


}
