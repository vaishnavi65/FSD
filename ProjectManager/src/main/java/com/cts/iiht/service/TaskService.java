package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.TaskDAO;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Task;
@ComponentScan("com.cts.iiht")
@Service
public class TaskService {
	@Autowired
	private TaskDAO taskDAO;
	@Autowired
	AllTaskDetails taskDetails;
	@Autowired
	public List<AllTaskDetails> getAllTasksSortBySDate(String projectName) {
		return taskDAO.getAllTasksSortBySDate(projectName);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByEDate(String projectName) {
		return taskDAO.getAllTasksSortByEDate(projectName);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByPriority(String projectName) {
		return taskDAO.getAllTasksSortByPriority(projectName);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByCompleted(String projectName) {
		return taskDAO.getAllTasksSortByCompleted(projectName);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasks(String projectName) {
		return taskDAO.getAllTasks(projectName);
	}
	@Autowired
	public void addTask(AllTaskDetails taskDet) {
		taskDAO.addTask(taskDet);
	}
	
/*	@Autowired
	public void updateTask(Task task) {
		taskDAO.updateTask(task);
} */
}
