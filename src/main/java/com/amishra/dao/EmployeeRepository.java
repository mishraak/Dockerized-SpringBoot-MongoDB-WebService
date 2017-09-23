package com.amishra.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.amishra.model.Employee;


@Repository
public class EmployeeRepository {
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
	
}
