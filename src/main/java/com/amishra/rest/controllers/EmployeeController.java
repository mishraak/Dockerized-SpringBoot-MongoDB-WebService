package com.amishra.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriTemplate;

import com.amishra.dao.EmployeeRepository;
import com.amishra.model.Employee;



@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//private static final Logger myLogger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "rest/employee/{id}", method = RequestMethod.GET )
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id)	{			
	
		Employee employee = employeeRepository.getEmployee(id); 
			
		if (employee == null)
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		//return employee;				
	}
	
	
	//Include location header
	@RequestMapping(value = "rest/employee", method = RequestMethod.POST )
	@ResponseBody	
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)	{							
		
		Employee retrievedEmployee = employeeRepository.getEmployee(employee.id); 			
		if (retrievedEmployee != null)
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT );					
		
		employeeRepository.addEmployee(employee);	
		
		HttpHeaders responseHeaders = new HttpHeaders();		
		responseHeaders.setLocation(new UriTemplate("/rest/employees").expand(employee.id));
		
		return new ResponseEntity<Employee>(employee, responseHeaders, HttpStatus.CREATED);																		
	}
	
	
	@RequestMapping(value = "rest/employee/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee emp = employeeRepository.updateEmployee(id, employee);
		if (emp != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);			
		} else {			
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "rest/employee/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id)	{			
	
		Employee emp = employeeRepository.getEmployee(id); 
			
		if (emp == null)
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		employeeRepository.deleteEmployee(id); 		
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	
	
}
