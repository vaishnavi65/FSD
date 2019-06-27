package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.ParentTaskDAO;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Project;

@Service
public class ParentTaskService {
	@Autowired
	private ParentTaskDAO parentTaskDAO;
	public List<ParentTask> getAllParentTask() {
		return parentTaskDAO.getAllParentTask();
	}
	
	@Autowired
	public void addParentTask(AllTaskDetails parentTask) {
		parentTaskDAO.addParentTask(parentTask);
	}
	
	@Autowired
	public void updateParentTask(ParentTask parentTask) {
		parentTaskDAO.updateParentTask(parentTask);
	} 
}