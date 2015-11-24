package com.hbcnf.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbcnf.app.domain.Employee;
import com.hbcnf.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@RequestMapping( "/list" )
	public List<Employee> getList() {
		return es.findAll();
	}
	
	@RequestMapping( "/list/{fname}" ) 
	public List<Employee> getListByFirstName (@PathVariable("fname") String fname) {
		return es.findByFirstName(fname);
	}
	
	@RequestMapping( "/{id}" )
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return es.findById(id);
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	@ResponseBody
	public Employee saveEmployee(Employee e) {
		es.addEmployee(e);
		return e;
	}
	
}
