package com.cg.trg.lapp.dao;

import java.sql.Savepoint;
import java.util.Collection;
import java.util.List;

import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.exception.duplicateEmployeeException;

public interface EmployeeDao {
	
	void Save(Employee e)throws duplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int empId);
	Employee getEmployee(int empId);
    Collection<Employee> getAllEmployees();
}
