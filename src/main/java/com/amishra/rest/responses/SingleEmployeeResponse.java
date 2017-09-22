package com.amishra.rest.responses;

import com.amishra.model.Employee;


public class SingleEmployeeResponse {

	private boolean success;
	private Employee person;
	
	public SingleEmployeeResponse(boolean success, Employee person) {
		this.success = success;
		this.person = person;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Employee getPersons() {
		return person;
	}
	public void setPerson(Employee person) {
		this.person = person;
	}
}
