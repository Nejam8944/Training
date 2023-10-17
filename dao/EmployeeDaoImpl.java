package com.cg.trg.lapp.dao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.exception.duplicateEmployeeException;

public class EmployeeDaoImpl implements EmployeeDao{

	
	Map<Integer, Employee> dataMap=new HashMap<Integer, Employee>();
	
	public EmployeeDaoImpl() {
		dataMap.put(100, new Employee(100, "Kishore", LocalDate.of(1999, 12, 23), 24000));
		dataMap.put(200, new Employee(200, "Keerthy", LocalDate.of(1998, 9, 23), 34000));
		dataMap.put(300, new Employee(300, "Kalam", LocalDate.of(2001, 5, 5), 40000));
		dataMap.put(400, new Employee(400, "Kaveri", LocalDate.of(2005, 3, 12), 76000));
	}
	
	@Override
	public void Save(Employee e) throws duplicateEmployeeException {
		if(dataMap.containsKey(e.getEmpId()))
			throw new duplicateEmployeeException("Employee with id "+e.getEmpId()+"already exits");
		dataMap.put(e.getEmpId(), e);
		
	}

	@Override
	public boolean update(Employee e) {
		if(dataMap.containsKey(e.getEmpId())) 
			dataMap.put(e.getEmpId(), e);
		return true;
	}

	@Override
	public boolean delete(int empId) {
		if(dataMap.containsKey(empId)) 
			dataMap.remove(empId);
		return true;
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee x= dataMap.get(empId);
		return x;
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		Collection<Employee> col=dataMap.values();
		return col;
	}
	

}
