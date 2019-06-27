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
