package com.cts.iiht.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iiht.model.Project;
import com.cts.iiht.service.ProjectService;
@RestController
public class ProjectManagerController {
	private static final Logger logger = Logger.getLogger(ProjectManagerController.class);
	@Autowired
	private  ProjectService service;
	/*
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public ModelAndView getIndexPageInfo() {
		logger.debug("Index page details are ProjectManager");
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "ProjectManager");
		return mv;
 	}*/
	
	@RequestMapping(value="/project/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> getProjectDetails() {
		List<Project> projects = service.getAllProjectData();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/user/addUser", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> addAnUser() {
		List<Project> projects = service.getAllProjectData();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
}


