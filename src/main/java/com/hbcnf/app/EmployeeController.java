package com.hbcnf.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbcnf.app.domain.Employee;
import com.hbcnf.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping( "/list" )
	public List<Employee> getList() {
		logger.info("Getting list of Employees");
		return es.findAll();
	}
	
	@RequestMapping( "/list/{fname}" ) 
	public List<Employee> getListByFirstName (@PathVariable("fname") String fname) {
		logger.info("Getting list of Employees by Name");
		return es.findByFirstName(fname);
	}
	
	@RequestMapping( "/{id}" )
	public Employee getEmployeeById(@PathVariable("id") int id) {
		logger.info("Getting list of Employees by Id");
		return es.findById(id);
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	@ResponseBody
	public Employee saveEmployee(Employee e) {
		logger.info("Saving Employee to database "+ e.toString());
		es.addEmployee(e);
		return e;
	}
	
}
