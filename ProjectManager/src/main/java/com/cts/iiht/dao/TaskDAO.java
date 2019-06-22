package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Task;

@Repository
@Transactional
public class TaskDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Task> getAllTasks() {
		List<?> list = entityManager.createQuery("SELECT t FROM Task t order by task_id asc").getResultList();
		return (List<Task>) list;
	}
	@SuppressWarnings("unchecked")
	public void addTask(Task task) {
		entityManager.persist(task);
		
	}
	@SuppressWarnings("unchecked")
	public void updateTask(Task task) {
		entityManager.merge(task);
		
	}
}
