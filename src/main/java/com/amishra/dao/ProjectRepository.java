package com.amishra.dao;

import java.util.List;

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
import com.amishra.model.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProjectRepository {

	public static final String projectsCollection = "project";
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
	
	//Dependency Injection
		@Autowired
		private MongoTemplate mongoTemplate;
		
		public void addProject(Project project){		
			mongoTemplate.insert(project, projectsCollection);			
		}
		
		
		public Project getProject(int projectId){			
			Query query = new Query(); 								
			query.addCriteria(
					Criteria
					.where("_id")
						.is(projectId)				
			);																	
			return mongoTemplate.findOne(query, Project.class, projectsCollection);			
		}


		public Project updateProject(int id, Project project) {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
	 
			Update update = new Update();
			
			Project retrievedProject = getProject(id);		
			
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonInString = null;
			try {
				 jsonInString = mapper.writeValueAsString(project);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			JSONObject jo = new JSONObject(jsonInString);
			
				if ( jo.isNull("name"))
					project.name=retrievedProject.name;
			
				
				if ( jo.get("budget").equals(new Double(0.0)))
					project.budget=retrievedProject.budget;				
 						
				
			update.set("name", project.name);							
			update.set("budget", project.budget);
			
			mongoTemplate.updateFirst(query, update, Project.class);        
	        
			return project;	
		}


		public void deleteProject(int id) {
			Project project = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Project.class, projectsCollection);
			mongoTemplate.remove(project, projectsCollection);		
		}


		public List<Project> getProjects() {
			return mongoTemplate.findAll(Project.class, projectsCollection);
		}

		
		
}
