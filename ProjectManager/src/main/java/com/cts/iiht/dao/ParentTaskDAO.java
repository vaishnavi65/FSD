package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Task;

@Repository
@Transactional
public class ParentTaskDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<ParentTask> getAllParentTask() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT parent FROM ParentTask parent order by parent_id asc").list();
		return (List<ParentTask>) list;
	}
	
	@SuppressWarnings("unchecked")
	public void addParentTask(ParentTask parentTask) {
		sessionFactory.getCurrentSession().persist(parentTask);
		
	}
	@SuppressWarnings("unchecked")
	public void updateParentTask(ParentTask parentTask) {
		sessionFactory.getCurrentSession().merge(parentTask);
		
	}
} 
