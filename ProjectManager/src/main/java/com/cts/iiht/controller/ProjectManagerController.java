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
	
	/*@RequestMapping(value="/project/add", method = RequestMethod.POST)
	 public ResponseEntity<Void> submitProject(@Valid @ModelAttribute("user")Project project, 
		      BindingResult result, ModelMap model) throws IOException, SQLException {
		        projectService.addProject(project);
				model.addAttribute("project", project.setProject());
				model.addAttribute("start_date", user.getLast_name());
				model.addAttribute("end_date", user.getEmployee_id());
				model.addAttribute("priority", user.getEmployee_id());
				model.addAttribute("status", user.getEmployee_id());
		        return "Project Added";
		    }
	@RequestMapping(value="/project/update", method = RequestMethod.POST)
	 public String updateProject(@Valid @ModelAttribute("user")Users user, 
		      BindingResult result, ModelMap model) throws IOException, SQLException {
		        userService.updateUser(user);
				model.addAttribute("first_name", user.getFirst_name());
				model.addAttribute("last_name", user.getLast_name());
				model.addAttribute("employee_id", user.getEmployee_id());
		        return "User Added";
		    }*/
	
	@RequestMapping(value="/user/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = userService.getAllUsers();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/user/add", method = RequestMethod.POST)
	 public String addUser(@Valid Users user, BindingResult result,
	            ModelMap model) throws IOException, SQLException {
		        userService.addUser(user);
		        model.addAttribute("success", "User " + user.getFirst_name() + " "+ user.getLast_name() + " registered successfully");
				return "Success";
		    }
	/*@RequestMapping(value = "/user/update{userId}", method = RequestMethod.PUT)
	public String updateUser(@Valid Users user, BindingResult result,
            ModelMap model, @PathVariable String userID) {		
		
		userService.updateUser(user,userID);
		return "Success";
	}
	/*@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<Users> findUserByName(@PathVariable String name, @RequestBody Users user) {
		String first_name=name;
		Users currentUser = userService.findByFirstName(first_name);
		
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


