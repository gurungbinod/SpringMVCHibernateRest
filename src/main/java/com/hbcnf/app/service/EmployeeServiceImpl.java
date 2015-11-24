package com.hbcnf.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbcnf.app.domain.Employee;
import com.hbcnf.app.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		employeeDao.save(e);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee e) {
		employeeDao.delete(e);
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public List<Employee> findByFirstName(String fname) {
		return employeeDao.findByFirstName(fname);
	}

	@Override
	@Transactional
	public List<Employee> findByFirstNameAndLastName(String fname, String lname) {
		return employeeDao.findByFirstNameAndLastName(fname, lname);
	}

}
