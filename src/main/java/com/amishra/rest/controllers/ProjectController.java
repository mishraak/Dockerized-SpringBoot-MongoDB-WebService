package com.amishra.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriTemplate;

import com.amishra.dao.ProjectRepository;
import com.amishra.exception.NegativeIDException;
import com.amishra.exception.ZeroRecordsFound;
import com.amishra.model.Employee;
import com.amishra.model.Project;

@Controller
@RequestMapping("/")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
		
	@RequestMapping(value = "rest/project/{id}", method = RequestMethod.GET )
	public ResponseEntity<Project> getProject(@PathVariable("id") int id)	{			
	
		Project project = projectRepository.getProject(id); 
			
		if (project == null)
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value = "rest/project", method = RequestMethod.GET )
	public ResponseEntity<List<Project>> getProject()	{			
		List<Project> projects  = projectRepository.getProjects();
		
		try{
			
			if (projects.size() == 0)
				//return new ResponseEntity<List<Project>>(HttpStatus.NOT_FOUND);
				//throw new ZeroRecordsFound();
				throw new Exception();
		}		
		catch (Exception e) {
			return new ResponseEntity<List<Project>>(HttpStatus.NOT_FOUND);
		}			
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);				
	}
	
	
	//Include location header
	@RequestMapping(value = "rest/project", method = RequestMethod.POST )
	@ResponseBody	
	public ResponseEntity<Project> addProject(@RequestBody Project project)	{							
		
		Project retrievedProject = projectRepository.getProject(project.id); 			
		if (retrievedProject != null)
			return new ResponseEntity<Project>(HttpStatus.CONFLICT );					
		
		if (project.id < 0)
			throw new NegativeIDException();
		
		projectRepository.addProject(project);	
		
		HttpHeaders responseHeaders = new HttpHeaders();		
		//responseHeaders.setLocation(new UriTemplate("/rest/project").expand(project.id));
		responseHeaders.add("Location", "/rest/project/" + project.id);
		
		return new ResponseEntity<Project>(project, responseHeaders, HttpStatus.CREATED);																		
	}
	
	
	@RequestMapping(value = "rest/project/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
		
		if (project.getId()  != id)
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
				
		Project proj = projectRepository.updateProject(id, project);

		if (proj != null) {
			return new ResponseEntity<Project>(proj, HttpStatus.OK);			
		} else {			
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "rest/project/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Project> deleteProject(@PathVariable("id") int id)	{			
	
		Project proj = projectRepository.getProject(id); 
			
		if (proj == null)
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
			
		projectRepository.deleteProject(id); 		
		return new ResponseEntity<Project>(HttpStatus.OK);
	}
	
	

}	
