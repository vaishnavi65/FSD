package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Task;

@Repository
@Transactional
public class TaskDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Task> getAllTasks() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t order by task_id asc").list();
		return (List<Task>) list;
	}
	@SuppressWarnings("unchecked")
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().persist(task);
		
	}
	@SuppressWarnings("unchecked")
	public void updateTask(Task task) {
		sessionFactory.getCurrentSession().merge(task);
		
	}
}
