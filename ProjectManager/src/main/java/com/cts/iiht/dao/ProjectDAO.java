package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

@Repository
@Transactional
public class ProjectDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		List<?> list = entityManager.createQuery("SELECT p FROM Project p order by project_id asc").getResultList();
		return (List<Project>) list;
	}
	@SuppressWarnings("unchecked")
	public void addProject(Project project) {
		entityManager.persist(project);
		
	}
	@SuppressWarnings("unchecked")
	public void updateProject(Project project) {
		entityManager.merge(project);
		
	}
} 