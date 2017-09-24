package com.amishra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.amishra.model.Project;

@Repository
public class ProjectRepository {

	public static final String projectsCollection = "project";
	
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
			update.set("name", project.name);
			update.set("budget", project.budget );		
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
