package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Project;

@Repository
@Transactional
public class ProjectDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		List<?> list = entityManager.createQuery("SELECT p FROM Project p").getResultList();
		return (List<Project>) list;
	}
} 