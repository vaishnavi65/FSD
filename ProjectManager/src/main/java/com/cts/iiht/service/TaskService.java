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
	public List<AllTaskDetails> getAllTasksSortBySDate(AllTaskDetails taskDetails) {
		return taskDAO.getAllTasksSortBySDate(taskDetails);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByEDate(AllTaskDetails taskDetails) {
		return taskDAO.getAllTasksSortByEDate(taskDetails);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByPriority(AllTaskDetails taskDetails) {
		return taskDAO.getAllTasksSortByPriority(taskDetails);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasksSortByCompleted(AllTaskDetails taskDetails) {
		return taskDAO.getAllTasksSortByCompleted(taskDetails);
	}
	@Autowired
	public List<AllTaskDetails> getAllTasks(AllTaskDetails taskDetails) {
		return taskDAO.getAllTasks(taskDetails);
	}
	@Autowired
	public void addTask(AllTaskDetails taskDet) {
		taskDAO.addTask(taskDet);
	}
	
	@Autowired
	public AllTaskDetails getTaskDetail(AllTaskDetails taskDetails) {
		return taskDAO.getTaskDetail(taskDetails);
	}
	
/*	@Autowired
	public void updateTask(Task task) {
		taskDAO.updateTask(task);
} */
}
