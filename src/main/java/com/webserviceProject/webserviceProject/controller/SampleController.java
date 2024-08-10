package com.webserviceProject.webserviceProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceProject.webserviceProject.bean.Employee;
import com.webserviceProject.webserviceProject.service.SampleService;

//http://localhost:9090/sample/response1
//http://localhost:9090/sample/response2

@RestController
@RequestMapping("/apiSample")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@GetMapping(value = "/sample")
	public int getIntValue() {
		return 1;
	}

	@RequestMapping(value = "/response1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getResponse() {

		String response = sampleService.getResponse();

		return response;
	}

	@RequestMapping(value = "/response2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getResponse1() {

		return "welcome to uniq";
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getResponse2() {

		List<Employee> response = sampleService.getEmployeeDetails();

		return response;
	}

	// http://localhost:9090/api/employee/uniq/12345?dummy=testdata

	@RequestMapping(value = "/employee/{empName}/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getResponse3(@PathVariable String empName, @PathVariable int empId,
			@RequestParam(value = "dummy", required = false) String dummy) {

		System.out.println(empName + " " + empId + " " + dummy);
		return empName;
	}

	@PostMapping("/addEmployee")
	public int addEmployee(@RequestBody Employee employee) {

		System.out.println(employee.toString());
		return 1;

	}

}
