package com.amishra.rest.responses;

import java.util.List;

import com.amishra.model.Employee;



public class MultiplePersonResponse {

	private boolean success;
	private List<Employee> persons;
	
	public MultiplePersonResponse(boolean success, List<Employee> persons) {
		this.success = success;
		this.persons = persons;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<Employee> getPersons() {
		return persons;
	}
	public void setPersons(List<Employee> persons) {
		this.persons = persons;
	}
	
}
