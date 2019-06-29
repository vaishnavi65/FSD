package com.cts.iiht.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

class ProjectManagerControllerTest {

	String deployedServerName="http://localhost:8090/ProjectManager";

	@Test
	void testGetProjectDetails() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/project/details";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	    
	}

	@Test
	void testSortBySDate() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/project/sortBySDate";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSortByEDate() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/project/sortByEDate";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSerachByPriority() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/project/sortByPriority";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSortByCompletion() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/project/sortByCompletion";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testAddProject() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/project/add";
	    AllProjectDetails project=createAllProjectDetailsToAdd();
	    URI uri = new URI(baseUrl);
	    HttpEntity<AllProjectDetails> request = new HttpEntity<>(project, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	

	@Test
	void testUpdateProject() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/project/update";
	    AllProjectDetails project=createAllProjectDetailsToUpdate();
	    URI uri = new URI(baseUrl);
	    HttpEntity<AllProjectDetails> request = new HttpEntity<>(project, headers);
	    restTemplate.put(uri, request);
	    Assertions.assertEquals(200, 200);
	}

	@Test
	void testSuspendProject() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/project/suspend";
	    Project project=createProjectDetailsToUpdate();
	    URI uri = new URI(baseUrl);
	    HttpEntity<Project> request = new HttpEntity<>(project, headers);
	    restTemplate.put(uri, request);
	    Assertions.assertEquals(200, 200);
	}

	private Project createProjectDetailsToUpdate() {
		Project project=new Project();
		project.setEnd_date(new Date());
		project.setPriority(1);
		project.setProject("Project1");
		project.setStart_date(new Date());
		project.setStatus("In Progress");
		return project;
	}

	@Test
	void testGetAllUsers() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/user/details";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSerachByFName() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/user/serachByFName";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSerachByLName() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/user/serachByLName";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testSerachById() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/user/serachById";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testAddUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/user/add";
	    Users user=createUserObj();
	    URI uri = new URI(baseUrl);
	    HttpEntity<Users> request = new HttpEntity<>(user, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testUpdateUser() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/user/update";
	    Users user=createUserObj();
	    URI uri = new URI(baseUrl);
	    HttpEntity<Users> request = new HttpEntity<>(user, headers);
	    restTemplate.put(uri, request);
	    Assertions.assertEquals(200, 200);
	}

	@Test
	void testDeleteUser() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/user/delete";
	    Users user=createUserObj();
	    URI uri = new URI(baseUrl);
	    HttpEntity<Users> request = new HttpEntity<>(user, headers);
	    restTemplate.put(uri, request);
	    Assertions.assertEquals(200, 200);
	}

	@Test
	void testSearchManagers() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/user/searchManagers";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllTasks() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllTasksSortBySDate() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/sortBySDate/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllTasksSortByEDate() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/sortByEDate/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllTasksSortByPriority() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/sortByPriority/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllTasksSortByCompleted() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/sortByCompleted/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetTaskDetail() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/task/details/task/Project1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testAddTask() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/task/add";
	    AllTaskDetails taskDetails=createAllTaskDetailsToUpdate();
	    URI uri = new URI(baseUrl);
	    HttpEntity<AllTaskDetails> request = new HttpEntity<>(taskDetails, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testGetAllParentTasks() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = deployedServerName + "/parentTask/details";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testAddParentTask() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    final String baseUrl = deployedServerName + "/parentTask/add";
	    AllTaskDetails project=createAllTaskDetailsToUpdate();
	    URI uri = new URI(baseUrl);
	    HttpEntity<AllTaskDetails> request = new HttpEntity<>(project, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assertions.assertEquals(200, result.getStatusCodeValue());
	}
	
	
	private AllProjectDetails createAllProjectDetailsToUpdate() {
		AllProjectDetails allProjectDetails=new AllProjectDetails();
		allProjectDetails.setCompleted_task(0L);
		allProjectDetails.setEnd_date(new Date());
		allProjectDetails.setStart_date(new Date());
		allProjectDetails.setManager_first_name("Mike");
		allProjectDetails.setManager_last_name("Cook");
		allProjectDetails.setPriority(1);
		allProjectDetails.setProject("Project1");
		allProjectDetails.setStatus("In Progress");
		allProjectDetails.setTotal_task(1L);
		return allProjectDetails;
	}

	private AllTaskDetails createAllTaskDetailsToUpdate() {
		AllTaskDetails taskDetails=new AllTaskDetails();
		taskDetails.setEnd_date(new Date());
		taskDetails.setParentTaskName("Parent_Task_1");
		taskDetails.setPriority(1);
		taskDetails.setProjName("Project1");
		taskDetails.setStart_date(new Date());
		taskDetails.setTask("Task 1");
		taskDetails.setTaskStatus("In Progress");
		taskDetails.setUserName("Mike Cook");
		return taskDetails;
	}

	private AllProjectDetails createAllProjectDetailsToAdd() {
		AllProjectDetails allProjectDetails=new AllProjectDetails();
		allProjectDetails.setCompleted_task(0L);
		allProjectDetails.setEnd_date(new Date());
		allProjectDetails.setStart_date(new Date());
		allProjectDetails.setManager_first_name("Mike");
		allProjectDetails.setManager_last_name("Cook");
		allProjectDetails.setPriority(1);
		allProjectDetails.setProject("ProjectTest");
		allProjectDetails.setStatus("In Progress");
		allProjectDetails.setTotal_task(1L);
		return allProjectDetails;
	}
	
	private Users createUserObj()
	{
		Users user=new Users();
		user.setFirst_name("Mike");
		user.setLast_name("Cook");
		user.setProject_id(1);
		user.setTask_id(2);
		user.setEmployee_id(3);
		return user;
	}

}
