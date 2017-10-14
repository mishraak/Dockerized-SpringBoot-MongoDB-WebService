package com.amishra.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.amishra.model.Employee;
<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class EmployeeRepository {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
	
=======
import com.amishra.rest.controllers.EmployeeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class EmployeeRepository {
	//private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
	public static final String employeesCollection = "employee";
			
	//Dependency Injection
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void addEmployee(Employee employee){		
		mongoTemplate.insert(employee, employeesCollection);			
	}
	
	
	public Employee getEmployee(int employeeId){			
		Query query = new Query(); 								
		query.addCriteria(
				Criteria
				.where("_id")
					.is(employeeId)				
		);																	
		return mongoTemplate.findOne(query, Employee.class, employeesCollection);			
	}


	public Employee updateEmployee(int id, Employee employee) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
 
		Update update = new Update();
		
		Employee retrievedEmployee = getEmployee(id);
		
<<<<<<< HEAD
		logger.info("fname : " + employee.fname );
		
		logger.info("lname : " + employee.lname );
=======
		//logger.info("fname : " + employee.fname );
		
		//logger.info("lname : " + employee.lname );
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonInString = null;
		try {
			 jsonInString = mapper.writeValueAsString(employee);
<<<<<<< HEAD
			logger.info(jsonInString);
=======
			//logger.info(jsonInString);
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


<<<<<<< HEAD
		
		JSONObject jo = new JSONObject(jsonInString);
		
		
=======
		JSONObject jo = new JSONObject(jsonInString);
		
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
			if ( jo.isNull("fname"))
				employee.fname=retrievedEmployee.fname;
		
			
			if ( jo.isNull("lname"))
				employee.lname=retrievedEmployee.lname;
		
<<<<<<< HEAD
		
=======
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
		update.set("fname", employee.fname);							
		update.set("lname", employee.lname);
		
		mongoTemplate.updateFirst(query, update, Employee.class);        
        
		return employee;	
<<<<<<< HEAD
        
=======
        	
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
	}


	public void deleteEmployee(int id) {
		Employee employee = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Employee.class, employeesCollection);
		mongoTemplate.remove(employee, employeesCollection);		
	}


	public List<Employee> getEmployees() {
		return mongoTemplate.findAll(Employee.class, employeesCollection);
	}
	
}
