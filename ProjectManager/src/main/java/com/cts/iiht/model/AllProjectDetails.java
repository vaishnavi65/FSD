package com.cts.iiht.model;

public class AllProjectDetails extends Project {
	String manager_first_name;
	String manager_last_name;
	long total_task;
	long completed_task;
	public String getManager_first_name() {
		return manager_first_name;
	}
	public void setManager_first_name(String manager_first_name) {
		this.manager_first_name = manager_first_name;
	}
	public long getTotal_task() {
		return total_task;
	}
	public void setTotal_task(long total_task) {
		this.total_task = total_task;
	}
	public long getCompleted_task() {
		return completed_task;
	}
	public void setCompleted_task(long completed_task) {
		this.completed_task = completed_task;
	}
	public String getManager_last_name() {
		return manager_last_name;
	}
	public void setManager_last_name(String manager_last_name) {
		this.manager_last_name = manager_last_name;
	}
	

}
