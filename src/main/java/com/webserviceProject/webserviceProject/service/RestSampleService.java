package com.webserviceProject.webserviceProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webserviceProject.webserviceProject.bean.Employee;

@Service
public class RestSampleService {

	@Autowired
	private RestTemplate restTemplate;

	private final String baseUrl = "http://localhost:9090/apiRest"; // Update this URL according to your application

	// For simple response body
	public String getHelloWorldForObject() {
		String url = baseUrl + "/response";
		return restTemplate.getForObject(url, String.class);

	}

	// For full response details
	public ResponseEntity<String> getHelloWorldForEntity() {
		String url = baseUrl + "/response";
		return restTemplate.getForEntity(url, String.class);
	}

	// For simple list response body
	public List<Employee> getEmployeeDetailsForObject() {
		String url = baseUrl + "/employees";
		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
		}).getBody();
	}

//    Generics and Type Erasure
//    Java uses a feature called generics, which allows you to specify types in a type-safe manner. However, during runtime, Java's type system uses a process called "type erasure." This means that the generic type information (like List<Employee>) is not available at runtime. For example, if you have a List<Employee> and a List<String>, both look like just List at runtime.

//    Using ParameterizedTypeReference
//    ParameterizedTypeReference allows you to retain the generic type information at runtime. This way, RestTemplate knows that it needs to deserialize the response into a List<Employee>.

	// For full response details of list
	public ResponseEntity<List<Employee>> getEmployeeDetailsForEntity() {
		String url = baseUrl + "/employees";
		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
		});
	}

	// For creating employee with simple response
	public Employee createEmployeeForObject(Employee employee) {
		String url = baseUrl + "/employees";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Test", "Data12345");
		HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
		return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Employee.class).getBody();
	}

	// For creating employee with full response details
	public ResponseEntity<Employee> createEmployeeForEntity(Employee employee) {
		String url = baseUrl + "/employees";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
		return restTemplate.exchange(url, HttpMethod.POST, requestEntity, Employee.class);
	}

	// For updating employee with simple response
	public Employee updateEmployee(int index, Employee employee) {
		String url = baseUrl + "/employees/" + index;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
		return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Employee.class).getBody();
	}

	public Employee updateEmployee(long id, Employee employee) {
		String url = baseUrl + "/employees/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
		ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Employee.class);
		return response.getBody();
	}

	public void deleteEmployee(long id) {
		String url = baseUrl + "/employees/" + id;
		restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
	}
}
