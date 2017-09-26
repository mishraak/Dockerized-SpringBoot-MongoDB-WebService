package com.amishra.dao;

import java.util.List;
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
import com.amishra.rest.controllers.EmployeeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class EmployeeRepository {
	//private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
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
		
		//logger.info("fname : " + employee.fname );
		
		//logger.info("lname : " + employee.lname );
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonInString = null;
		try {
			 jsonInString = mapper.writeValueAsString(employee);
			//logger.info(jsonInString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


		JSONObject jo = new JSONObject(jsonInString);
		
			if ( jo.isNull("fname"))
				employee.fname=retrievedEmployee.fname;
		
			
			if ( jo.isNull("lname"))
				employee.lname=retrievedEmployee.lname;
		
		update.set("fname", employee.fname);							
		update.set("lname", employee.lname);
		
		mongoTemplate.updateFirst(query, update, Employee.class);        
        
		return employee;	
        	
	}


	public void deleteEmployee(int id) {
		Employee employee = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Employee.class, employeesCollection);
		mongoTemplate.remove(employee, employeesCollection);		
	}


	public List<Employee> getEmployees() {
		return mongoTemplate.findAll(Employee.class, employeesCollection);
	}
	
}
