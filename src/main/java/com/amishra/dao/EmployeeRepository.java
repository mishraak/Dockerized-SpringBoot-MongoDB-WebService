package com.amishra.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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


	public Employee updateEmployee(int id, Employee employee) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
 
		Update update = new Update();
		update.set("fname", employee.getFname());
		update.set("lname", employee.lname);		
		mongoTemplate.updateFirst(query, update, Employee.class);        
        return employee;		
	}


	public void deleteEmployee(int id) {
		Employee employee = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Employee.class, employeesCollection);
		mongoTemplate.remove(employee, employeesCollection);		
	}
	
}
