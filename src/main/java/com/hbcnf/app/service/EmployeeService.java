package com.hbcnf.app.service;

import java.util.List;

import com.hbcnf.app.domain.Employee;

public interface EmployeeService {
	
	//retrieved from crud
	void addEmployee(Employee e);
	List<Employee> findAll();
	void updateEmployee(Employee e);
	void deleteEmployee(Employee e);
	Employee findById(int id);
	
	//custom queries
	List<Employee> findByFirstName(String fname);
	List<Employee> findByFirstNameAndLastName(String fname, String lname);
}
