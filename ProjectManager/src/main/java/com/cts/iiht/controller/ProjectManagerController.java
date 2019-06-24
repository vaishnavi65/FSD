package com.cts.iiht.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Task;
import com.cts.iiht.model.Users;
import com.cts.iiht.service.ParentTaskService;
import com.cts.iiht.service.ProjectService;
import com.cts.iiht.service.TaskService;
import com.cts.iiht.service.UserService;
@RestController
@Configuration
@ComponentScan("com.cts.iiht")
public class ProjectManagerController {
	private static final Logger logger = Logger.getLogger(ProjectManagerController.class);
	@Autowired
	private  ProjectService projectService;
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	private  TaskService taskService;
	
	@Autowired
	private  ParentTaskService parentTaskService;

		
	@RequestMapping(value="/project/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> getProjectDetails() {
		List<Project> projects = projectService.getAllProjectData();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortBySDate", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> sortBySDate() {
		List<Project> projects = projectService.sortBySDate();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByEDate", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> sortByEDate() {
		List<Project> projects = projectService.sortByEDate();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByPriority", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> serachByPriority() {
		List<Project> projects = projectService.sortByPriority();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByCompletion", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> sortByCompletion() {
		List<Project> projects = projectService.sortByCompletion();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/project/add", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addUser(@RequestBody Project project) throws IOException, SQLException {
		        logger.debug("project details"+project.getProject());
		        projectService.addProject(project);
		    }
	@RequestMapping(value = "/project/update", method = RequestMethod.PUT,headers = "Accept=application/json")
	public String updateUser(@RequestBody Project project) throws IOException, SQLException {	
		logger.debug("User details"+project.getProject());
		projectService.updateProject(project);
		return "Success";
	}
	/*@RequestMapping(value = "/project/suspend", method = RequestMethod.PUT,headers = "Accept=application/json")
	public String deleteUser(@RequestBody Project project) throws IOException, SQLException {		
		logger.debug("project details"+project.getProject());
		projectService.suspendProject(project);
		return "Success";
	}*/
	@RequestMapping(value="/user/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = userService.getAllUsers();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
 	}
	@RequestMapping(value="/user/serachByFName", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> serachByFName() {
		List<Users> users = userService.serachByFName();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
 	}
	@RequestMapping(value="/user/serachByLName", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> serachByLName() {
		List<Users> users = userService.serachByLName();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
 	}
	@RequestMapping(value="/user/serachById", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> serachById() {
		List<Users> users = userService.serachById();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/user/add", method = RequestMethod.POST, headers = "Accept=application/json")
	 public Users addUser(@RequestBody Users user) throws IOException, SQLException {
		        logger.debug("User details"+user.getFirst_name()+" "+user.getLast_name());
		        return userService.addUser(user);
		    }
	@RequestMapping(value = "/user/update", method = RequestMethod.PUT,headers = "Accept=application/json")
	public String updateUser(@RequestBody Users user) throws IOException, SQLException {	
		logger.debug("User details"+user.getFirst_name()+" "+user.getLast_name());
		userService.updateUser(user);
		return "Success";
	}
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE,headers = "Accept=application/json")
	public String deleteUser(@RequestBody Users user) throws IOException, SQLException {		
		logger.debug("User details"+user.getFirst_name()+" "+user.getLast_name());
		userService.deleteUser(user);
		return "Success";
	}
	/*
    @RequestMapping(value = "/user/detail/{id}", method = RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<Users> findUserById(@PathVariable("id") int id) {
    	Users users = userService.findById(id);
		logger.debug("project details are "+users);
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
/*	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> findUserById(@PathVariable("id") int id) {
		//String first_name=name;
		Users currentUser=new Users();
		currentUser = userService.findById(id);
		
		if (currentUser==null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Users>(currentUser, HttpStatus.OK);
	}*/
	
	@RequestMapping(value="/task/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		logger.debug("project details are "+tasks);
		return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/parentTask/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParentTask>> getAllParentTasks() {
		List<ParentTask> parentTasks = parentTaskService.getAllParentTask();
		logger.debug("project details are "+parentTasks);
		return new ResponseEntity<List<ParentTask>>(parentTasks,HttpStatus.OK);
 	}
}


