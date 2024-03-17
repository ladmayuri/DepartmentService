package com.example.DepartmentService.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DepartmentService.EmployeeConsumer.Employee;
import com.example.DepartmentService.EmployeeConsumer.EmployeeConsumer;
import com.example.DepartmentService.Model.Department;
import com.example.DepartmentService.Repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository deptRepo;
	
	public DepartmentService(DepartmentRepository deptRepo) {
		this.deptRepo=deptRepo;
	}
	
	public Department saveDepartment(Department request) {

		return deptRepo.save(request);
	}

	public Department findEmpById(Long id) {
		Optional<Department> optDb = deptRepo.findById(id);
		if (optDb.isPresent())
			return optDb.get();
		else
			throw new RuntimeException("Record with Dept Id: " + id + " not forund");

	}

	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}
	
//	public Department findBydeptId(Long id) {
//		Department dept = deptRepo.findByDeptId(id);
//		if (dept != null)
//			return dept;
//		else
//			throw new RuntimeException("Record with Dept Id: " + id + " not found");
//
//	}
	public Map findByDeptId(Long id) {
		Department dept = deptRepo.findByDeptId(id);
		EmployeeConsumer empConsumer=new EmployeeConsumer();

		List<Employee> listEmployee= empConsumer.empConsumer(id);
		Map< String, Object> response=new HashMap<>();
		response.put("department", dept);
		response.put("employees", listEmployee);
		
		
	return response;

	}

}
