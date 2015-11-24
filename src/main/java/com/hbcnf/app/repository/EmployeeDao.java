package com.hbcnf.app.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.hbcnf.app.domain.Employee;

@org.springframework.stereotype.Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	List<Employee> findByFirstName(String fname);
	List<Employee> findByFirstNameAndLastName(String fname, String lname);
	Employee findById(Integer id);
}
