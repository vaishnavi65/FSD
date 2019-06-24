package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

@Repository
@Transactional
public class ProjectDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null order by p.project_id asc").list();
		return (List<Project>) list;
	}
	public List<Project> sortBySDate() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null order by p.start_date asc").list();
		return (List<Project>) list;
	}
	public List<Project> sortByEDate() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null order by p.end_date asc").list();
		return (List<Project>) list;
	}
	public List<Project> sortByPriority() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null order by p.priority asc").list();
		return (List<Project>) list;
	}
	public List<Project> sortByCompletion() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status='Completed' order by p.start_date asc").list();
		return (List<Project>) list;
	}
	@SuppressWarnings("unchecked")
	public void addProject(Project project) {
		List<?> list =sessionFactory.getCurrentSession()
				.createQuery("SELECT p FROM Project p where p.project=:proj")
				.setParameter("proj", project.getProject()).list();
		if(list.isEmpty())
		{
		sessionFactory.getCurrentSession().save(project);
		}
		else
		{
			updateProject(project);
		}
		
	}
	@SuppressWarnings("unchecked")
	public void updateProject(Project project) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Project p set p.start_date=:sDate,p.end_date=:eDate,p.priority=:priority,p.status=:status where p.project=:proj")
		.setParameter("sDate", project.getStart_date()).setParameter("eDate", project.getEnd_date())
		.setParameter("priority", project.getPriority()).setParameter("status", project.getStatus())
		.setParameter("proj", project.getProject()).executeUpdate();
		
	}
	public void suspendProject(Project project) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Project p set p.status=\'Closed\' where p.project=:proj")
		.setParameter("proj", project.getProject()).executeUpdate();
		
	}
} 