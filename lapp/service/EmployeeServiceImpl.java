package com.cg.trg.lapp.service;

import java.util.Collection;

import com.cg.trg.lapp.dao.EmployeeDao;
import com.cg.trg.lapp.dao.EmployeeDaoImpl;
import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.exception.duplicateEmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeDao dao=new EmployeeDaoImpl();
	
	
	@Override
	public boolean addEmployee(Employee e) {
		try {
			dao.Save(e);
			return true;
			
		} catch (duplicateEmployeeException e1) {
			return false;
		}
	}
	
	@Override
	public Employee getEmployee(int eid) {
		Employee x=dao.getEmployee(eid);
		return x;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		return dao.delete(eid);
	}

	@Override
	public boolean grantIncrement(int eid, int percent) {
		Employee e=dao.getEmployee(eid);
		if(e==null)
			return false;
		int sal= (int)(e.getSalary()+(float)e.getSalary()*percent/100);
		e.setSalary(sal);
	
		return false;
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	@Override
	public Employee getYoungestEmployee() {
		
		Collection<Employee> allEmployees = dao.getAllEmployees();
		Employee youngest = null;
		for(Employee e: allEmployees) {
			if(youngest==null) {
				youngest=e;
			}
			if(e.getDob().compareTo(youngest.getDob())>0) {
				youngest=e;
			}
		}
		return youngest;
	}

	

}
