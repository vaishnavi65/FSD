package com.cts.iiht.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Project;
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
	public ResponseEntity<List<AllProjectDetails>> getProjectDetails() {
		List<AllProjectDetails> projects = projectService.getAllProjectData();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<AllProjectDetails>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortBySDate", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllProjectDetails>> sortBySDate() {
		List<AllProjectDetails> projects = projectService.sortBySDate();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<AllProjectDetails>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByEDate", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllProjectDetails>> sortByEDate() {
		List<AllProjectDetails> projects = projectService.sortByEDate();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<AllProjectDetails>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByPriority", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllProjectDetails>> serachByPriority() {
		List<AllProjectDetails> projects = projectService.sortByPriority();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<AllProjectDetails>>(projects,HttpStatus.OK);
 	}
	@RequestMapping(value="/project/sortByCompletion", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllProjectDetails>> sortByCompletion() {
		List<AllProjectDetails> projects = projectService.sortByCompletion();
		logger.debug("project details are "+projects);
		return new ResponseEntity<List<AllProjectDetails>>(projects,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/project/add", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addProject(@RequestBody AllProjectDetails project) throws IOException, SQLException {
		        logger.debug("project details"+project.getProject());
		        projectService.addProject(project);
		    }
	@RequestMapping(value = "/project/update", method = RequestMethod.PUT,headers = "Accept=application/json")
	public ResponseEntity<String> updateProject(@RequestBody AllProjectDetails project) throws IOException, SQLException {	
		logger.debug("User details"+project.getProject());
		projectService.updateProject(project);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/project/suspend", method = RequestMethod.PUT,headers = "Accept=application/json")
	public ResponseEntity<String> suspendProject(@RequestBody Project project) throws IOException, SQLException {	
		logger.debug("User details"+project.getProject());
		projectService.suspendProject(project);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
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
	public ResponseEntity<String> updateUser(@RequestBody Users user) throws IOException, SQLException {	
		logger.debug("User details"+user.getFirst_name()+" "+user.getLast_name());
		userService.updateUser(user);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	@RequestMapping(value = "/user/delete", method = RequestMethod.PUT,headers = "Accept=application/json")
	public ResponseEntity<String> deleteUser(@RequestBody Users user) throws IOException, SQLException {		
		logger.debug("User details"+user.getFirst_name()+" "+user.getLast_name());
		userService.deleteUser(user);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	@RequestMapping(value = "/user/searchManagers", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> searchManagers(){		
		List<Users> users=userService.searchManagers();
		logger.debug("project details are "+users);
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/task/details/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllTaskDetails>> getAllTasks(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setProjName(name);
		List<AllTaskDetails> tasks = taskService.getAllTasks(taskDetails);
		return new ResponseEntity<List<AllTaskDetails>>(tasks,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/task/details/sortBySDate/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllTaskDetails>> getAllTasksSortBySDate(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setProjName(name);
		List<AllTaskDetails> tasks = taskService.getAllTasksSortBySDate(taskDetails);
		return new ResponseEntity<List<AllTaskDetails>>(tasks,HttpStatus.OK);
 	}
	@RequestMapping(value="/task/details/sortByEDate/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllTaskDetails>> getAllTasksSortByEDate(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setProjName(name);
		List<AllTaskDetails> tasks = taskService.getAllTasksSortByEDate(taskDetails);
		return new ResponseEntity<List<AllTaskDetails>>(tasks,HttpStatus.OK);
 	}
	@RequestMapping(value="/task/details/sortByPriority/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllTaskDetails>> getAllTasksSortByPriority(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setProjName(name);
		List<AllTaskDetails> tasks = taskService.getAllTasksSortByPriority(taskDetails);
		return new ResponseEntity<List<AllTaskDetails>>(tasks,HttpStatus.OK);
 	}
	@RequestMapping(value="/task/details/sortByCompleted/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AllTaskDetails>> getAllTasksSortByCompleted(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setProjName(name);
		List<AllTaskDetails> tasks = taskService.getAllTasksSortByCompleted(taskDetails);
		return new ResponseEntity<List<AllTaskDetails>>(tasks,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/task/details/task/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AllTaskDetails> getTaskDetail(@PathVariable String name) {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setTask(name);
		AllTaskDetails task = taskService.getTaskDetail(taskDetails);
		return new ResponseEntity <AllTaskDetails>(task,HttpStatus.OK);
 	}
	
	@RequestMapping(value="/task/add", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addTask(@RequestBody AllTaskDetails taskDetails) throws IOException, SQLException {
		        taskService.addTask(taskDetails);
		    }
	
	@RequestMapping(value="/parentTask/details", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParentTask>> getAllParentTasks() {
		List<ParentTask> parentTasks = parentTaskService.getAllParentTask();
		return new ResponseEntity<List<ParentTask>>(parentTasks,HttpStatus.OK);
 	}
	@RequestMapping(value="/parentTask/add", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addParentTask(@RequestBody AllTaskDetails taskDetails) throws IOException, SQLException {
		        parentTaskService.addParentTask(taskDetails);
		    }
}


