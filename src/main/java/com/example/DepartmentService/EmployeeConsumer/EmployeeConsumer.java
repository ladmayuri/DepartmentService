package com.example.DepartmentService.EmployeeConsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import jakarta.annotation.PostConstruct;

public class EmployeeConsumer {
	RestTemplate restTemplate = new RestTemplate();
	public List<Employee> empConsumer(Long deptId) {
		String url="http://localhost:8085/employee/"+deptId;
		
		ResponseEntity<List<Employee>> empList= restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		List<Employee> list = empList.getBody();
		System.out.println("Size is---" + list.size());

		if (list.size() > 0) {
			return list;
		}else
			throw new RuntimeException("Record not forund");
	}

}
