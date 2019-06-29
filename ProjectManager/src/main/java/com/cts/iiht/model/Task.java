package com.cts.iiht.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="task_id",insertable=false, updatable=false)
	Integer task_id;
	@Column(name="parent_id")
    Integer parent_task_id;
	@Column(name="project_id")
    Integer project_id;
	@Column(name="task")
    String task;
	@Column(name="start_date")
    Date start_date;
	@Column(name="end_date")
    Date end_date;
	@Column(name="priority")
    Integer priority;
	@Column(name="status")
	String task_status;
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public Integer getParent_id() {
		return parent_task_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_task_id = parent_id;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getTaskStatus() {
		return task_status;
	}
	public void setTaskStatus(String task_status) {
		this.task_status = task_status;
	}
    
    
}
