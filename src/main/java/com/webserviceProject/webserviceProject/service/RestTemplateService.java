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
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:9090/apiRest"; // Update this URL according to your application

    public String getHelloWorld() {
        String url = baseUrl + "/response";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public List<Employee> getEmployeeDetails() {
        String url = baseUrl + "/employees";
        ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<Employee>>() {});
        return response.getBody();
    }

    public Employee createEmployee(Employee employee) {
        String url = baseUrl + "/employees";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Employee.class);
        return response.getBody();
    }

    public void updateEmployee(long id, Employee employee) {
        String url = baseUrl + "/employees/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
        restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Void.class);
    }

    public void deleteEmployee(long id) {
        String url = baseUrl + "/employees/" + id;
        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }
}
