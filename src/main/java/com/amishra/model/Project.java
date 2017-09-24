package com.amishra.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Pojo Project
@Document
public class Project {
	
	@Id
	public int id;
	
	public String name;
	public float budget;
	
	public Project() {
		super();
	}

	public Project(int id, String name, float budget) {
		super();
		this.id = id;
		this.name = name;
		this.budget = budget;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", budget=" + budget + "]";
	}
}
