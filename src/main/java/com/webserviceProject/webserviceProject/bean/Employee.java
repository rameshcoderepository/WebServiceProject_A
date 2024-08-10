package com.webserviceProject.webserviceProject.bean;

public class Employee {

	private String empName;
	private long empSalary;
	private int empAge;

	public Employee() {

	}

	public Employee(String empName, long empSalary, int empAge) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge + "]";
	}

}
