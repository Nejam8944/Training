package com.cg.trg.lapp.ui;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.service.EmployeeService;
import com.cg.trg.lapp.service.EmployeeServiceImpl;

public class LappMain {
	public static void main(String[] args) {

		EmployeeService service = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		while (true) {

			System.out.println(
					

					"1. List all employees \n2. Find employee \n3. Delete Employee \n4. Update salary increment of employee \n5. Find Youngest Employee \n6. Add Employee");

			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			switch (choice) {

			case 1:

				Collection<Employee> emps = service.getAllEmployees();

				for (Employee emp : emps) {

					System.out.println(emp);

				}

				break;

			case 2:

				System.out.print("Enter employee id: ");

				int empId = sc.nextInt();

				Employee emp = service.getEmployee(empId);

				if (emp == null) {

					System.out.println("Employee with " + empId + " EmpId not found.");

				} else {

					System.out.println(emp);

				}

				break;

			case 3:

				System.out.print("Enter employee id: ");

				int empid = sc.nextInt();

				if (service.deleteEmployee(empid)) {

					System.out.println("Success!!");

				} else {

					System.out.println("EmpId not match");

				}

				break;

			case 4:

				System.out.print("Enter employee id: ");

				empid = sc.nextInt();

				System.out.print("Enter Percentage of increament: ");

				int percentage = sc.nextInt();

				if (service.grantIncrement(empid, percentage)) {

					System.out.println("Success!!");

				} else {

					System.out.println("EmpId not match");

				}

				break;

			case 5:

				System.out.println(service.getYoungestEmployee());
				
			case 6:

				System.out.print("Enter employee id: ");
				int empId1 = sc.nextInt();
				System.out.print("Enter employee name: ");
				String name = sc.next();
				System.out.print("Enter employee dob: yyyy/MM/dd format ");
				LocalDate dob = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
				System.out.print("Enter employee salary: ");
				int salary = sc.nextInt();
				

				if (service.addEmployee(new Employee(empId1, name, dob, salary))) {

					System.out.println("Success!!✅ Employee "+name+" has been added to the database");

				} else {

					System.out.println("EmpId not added");

				}

				break;

			default:

				System.out.println("Wrong Choice!!");

			}

			System.out.print("Want to continue(y/n): ");

			String ch = sc.next();

			if (ch.charAt(0) != 'y') {
				break;
			}
		}
	}
}
