package com.cts.iiht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parent_task")
public class ParentTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parent_id",insertable=false, updatable=false)
	Integer parent_id;
	@Column(name="parent_task")
	String parent_task;
	
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_task() {
		return parent_task;
	}
	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}
	
	

}
