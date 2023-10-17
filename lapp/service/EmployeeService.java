package com.cg.trg.lapp.service;

import java.util.Collection;

import com.cg.trg.lapp.dto.Employee;

public interface EmployeeService {
	
	Employee getEmployee(int eid);
	boolean addEmployee(Employee e);
	boolean deleteEmployee(int eid);
	boolean grantIncrement(int eid,int percent);
	
	Collection<Employee> getAllEmployees();
	
	Employee getYoungestEmployee();

}
