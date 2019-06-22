package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Task;

@Repository
@Transactional
public class ParentTaskDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<ParentTask> getAllParentTask() {
		List<?> list = entityManager.createQuery("SELECT parent FROM ParentTask parent order by parent_id asc").getResultList();
		return (List<ParentTask>) list;
	}
	
	@SuppressWarnings("unchecked")
	public void addParentTask(ParentTask parentTask) {
		entityManager.persist(parentTask);
		
	}
	@SuppressWarnings("unchecked")
	public void updateParentTask(ParentTask parentTask) {
		entityManager.merge(parentTask);
		
	}
} 
