package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.ProjectDAO;
import com.cts.iiht.dao.UserDAO;
import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

@Service
public class ProjectService {
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private UserDAO userDAO;
	public List<AllProjectDetails> getAllProjectData() {
		return projectDAO.getAllProjects();
	}
	public List<AllProjectDetails> sortBySDate() {
		return projectDAO.sortBySDate();
	}
	public List<AllProjectDetails> sortByEDate() {
		return projectDAO.sortByEDate();
	}
	public List<AllProjectDetails> sortByPriority() {
		return projectDAO.sortByPriority();
	}
	public List<AllProjectDetails> sortByCompletion() {
		return projectDAO.sortByCompletion();
	}
	
	public void addProject(AllProjectDetails project) {
		projectDAO.addProject(project);
				
	}
	
	public void updateProject(AllProjectDetails project) {
		projectDAO.updateProject(project);
	} 
	public void suspendProject(Project project) {
		projectDAO.suspendProject(project);
	} 
} 
