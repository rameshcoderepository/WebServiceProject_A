package com.webserviceProject.webserviceProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceProject.webserviceProject.bean.Employee;
import com.webserviceProject.webserviceProject.service.RestTemplateService;

//getForObject
//Purpose: Retrieve a resource directly as an object.
//Return Type: Returns the response body directly, converted to the specified type.

//getForEntity
//Purpose: Retrieve a resource as a ResponseEntity, which includes the response body, status code, and headers.
//Return Type: Returns a ResponseEntity<T>, where T is the type of the response body.

//Use getForObject for simple GET requests when only the response body is needed.
//Use getForEntity when you need the full HTTP response details.
//Use exchange for the most flexibility, including custom HTTP methods and complex request/response handling.

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

	@Autowired
	private RestTemplateService restTemplateService;

	@GetMapping("/response")
	public String getResponse() {
		return restTemplateService.getHelloWorld();
	}

	@GetMapping("/employees")
	public List<Employee> getEmployeeDetails() {
		return restTemplateService.getEmployeeDetails();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return restTemplateService.createEmployee(employee);
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
