package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.TaskDAO;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Task;

@Service
public class TaskService {
	@Autowired
	private TaskDAO taskDAO;
	public List<Task> getAllTasks() {
		return taskDAO.getAllTasks();
	}
/*	@Autowired
	public void addTask(Task task) {
		taskDAO.addTask(task);
	}
	
	@Autowired
	public void updateTask(Task task) {
		taskDAO.updateTask(task);
} */
}
