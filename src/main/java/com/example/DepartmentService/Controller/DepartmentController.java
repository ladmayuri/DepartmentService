package com.example.DepartmentService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DepartmentService.EmployeeConsumer.EmployeeConsumer;
import com.example.DepartmentService.Model.Department;
import com.example.DepartmentService.Service.DepartmentService;


@RestController
public class DepartmentController {
	Map<String, Object> empResponse = new HashMap<>();
	@Autowired
	private DepartmentService deptService;	
	public DepartmentController(DepartmentService deptService) {
		this.deptService=deptService;
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAllEmployees(){
		return new ResponseEntity<List<Department>>(deptService.getAllDepartment(),HttpStatus.OK);		
	}
	@GetMapping("/department/{deptid}")
	public ResponseEntity<Object> findBydeptId(@PathVariable Long deptid){
		return new ResponseEntity<>(deptService.findByDeptId(deptid),HttpStatus.OK);
	}
	@PostMapping("/department/saveDepartment")
	public ResponseEntity<Department> saveEmployee(@RequestBody Department request){
		// Map implementation using HashMap
		return new ResponseEntity<>(deptService.saveDepartment(request),HttpStatus.CREATED);
	}

}
