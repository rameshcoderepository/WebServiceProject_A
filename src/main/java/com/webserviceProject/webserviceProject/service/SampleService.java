package com.webserviceProject.webserviceProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webserviceProject.webserviceProject.bean.Employee;

@Service
public class SampleService {

	public String getResponse() {
		return "Hello World";
	}

	public List<Employee> getEmployeeDetails() {

		Employee emp = new Employee("one", 233l, 18);
		Employee emp1 = new Employee("two", 233l, 18);
		Employee emp2 = new Employee("three", 233l, 18);
		Employee emp3 = new Employee("four", 233l, 18);
		Employee emp4 = new Employee("five", 233l, 18);

		List<Employee> empList = new ArrayList<Employee>();

		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);

		return empList;

	}

}
