package com.webserviceProject.webserviceProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceProject.webserviceProject.bean.Employee;
import com.webserviceProject.webserviceProject.service.RestSampleService;

//http://localhost:8080/apiSample/response

@RestController
@RequestMapping("/apiSample")
public class RestSampleController {

	@Autowired
	private RestSampleService restTemplateService;

	@GetMapping("/response")
	public String getResponse() {
		return restTemplateService.getHelloWorldForObject();
	}

	@GetMapping("/response/entity")
	public ResponseEntity<String> getResponseEntity() {
		return restTemplateService.getHelloWorldForEntity();
	}

	@GetMapping("/employees")
	public List<Employee> getEmployeeDetails() {
		return restTemplateService.getEmployeeDetailsForObject();
	}

	@GetMapping("/employees/entity")
	public ResponseEntity<List<Employee>> getEmployeeDetailsEntity() {
		return restTemplateService.getEmployeeDetailsForEntity();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return restTemplateService.createEmployeeForObject(employee);
	}

	@PostMapping("/employees/entity")
	public ResponseEntity<Employee> createEmployeeEntity(@RequestBody Employee employee) {
		return restTemplateService.createEmployeeForEntity(employee);
	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		restTemplateService.updateEmployee(id, employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		restTemplateService.deleteEmployee(id);
	}
}
