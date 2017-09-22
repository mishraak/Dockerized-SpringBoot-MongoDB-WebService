package com.amishra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.amishra.model.Employee;


@Repository
public class EmployeeRepository {
	public static final String employeesCollection = "employees";
	
	//Dependency Injection
	@Autowired
	public MongoTemplate mongoTemplate;
	
	
	public void addEmployee(Employee employee){
		if(!mongoTemplate.collectionExists(Employee.class))
			mongoTemplate.createCollection(Employee.class);
		
		mongoTemplate.insert(employee, employeesCollection);			
	}
	
	
	public Employee getEmployee(int employeeId){	
		
		Query query = new Query(); 								
		/*query.addCriteria(
				Criteria
				.where("id")
					.is(employeeId)				
		);
		*/
		
		System.out.print("\n" + employeeId + "\n");
		query.addCriteria(
				Criteria
				.where("_id")
					.is(employeeId)				
		);															
		
		return mongoTemplate.findOne(query, Employee.class, employeesCollection);			
	}
	
}
