package com.amishra.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amishra.dao.EmployeeRepository;
import com.amishra.model.Employee;
import com.amishra.rest.responses.BasicResponse;
import com.amishra.rest.responses.SingleEmployeeResponse;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger myLogger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET )
	public Employee getEmployee(@PathVariable("id") int id)	{
		myLogger.info("Retrieving employee with id :" + id);
		
		Employee employee = employeeRepository.getEmployee(id); 
		
		if ( employee != null )
			myLogger.info("Person retrieved : " + employee.fname + " " + employee.lname);
		else{
			myLogger.info("Person with id: "+ id +" not found!");
			SingleEmployeeResponse resp = new SingleEmployeeResponse(true, employee);
		}
		
		return employee;
		
		}
	
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST  ) 
	public void addEmployee( @RequestBody Employee employee ) {
		//myLogger.info("add Employee called for employee " + employee.toString());
		
		//Employee retrievedEmployee = employeeRepository.getEmployee(employee.id);
		//BasicResponse resp;
		
		
		//if (retrievedEmployee != null) {
			//myLogger.info("Failed to insert...");
			//resp = new BasicResponse(false, "Failed to insert..."); 
		//}
		//else {
			//myLogger.info("adding: " + employee.toString());
			employeeRepository.addEmployee(employee);
			//resp = new BasicResponse(true, "Successfully added Person: " + employee.getFname());
		//}
			
		
	} 
}
