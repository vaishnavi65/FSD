package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.ProjectDAO;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

@Service
public class ProjectService {
	@Autowired
	private ProjectDAO projectDAO;
	public List<Project> getAllProjectData() {
		return projectDAO.getAllProjects();
	}
	public List<Project> sortBySDate() {
		return projectDAO.sortBySDate();
	}
	public List<Project> sortByEDate() {
		return projectDAO.sortByEDate();
	}
	public List<Project> sortByPriority() {
		return projectDAO.sortByPriority();
	}
	public List<Project> sortByCompletion() {
		return projectDAO.sortByCompletion();
	}
	
	public void addProject(Project project) {
		projectDAO.addProject(project);
	}
	
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
	} 
	public void suspendProject(Project project) {
		projectDAO.suspendProject(project);
	} 
} 
