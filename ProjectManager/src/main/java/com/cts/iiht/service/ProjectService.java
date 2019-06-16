package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.ProjectDAO;
import com.cts.iiht.model.Project;

@Service
public class ProjectService {
	@Autowired
	private ProjectDAO projectDAO;
	public List<Project> getAllProjectData() {
		return projectDAO.getAllProjects();
	}
} 
