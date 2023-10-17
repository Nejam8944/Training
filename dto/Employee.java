package com.cg.trg.lapp.dto;

import java.time.LocalDate;

public class Employee {//DTO
	private int empId;
	private String name;
	private LocalDate dob;
	private int salary;
	
	public Employee(int empId, String name, LocalDate dob, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dob=" + dob + ", salary=" + salary + "]";
	}
	

	
}
