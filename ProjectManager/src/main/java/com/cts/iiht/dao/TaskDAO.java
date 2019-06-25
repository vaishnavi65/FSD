package com.cts.iiht.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.AllProjectDetails;
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
	
	public List<AllProjectDetails> getTaskDetails(List<AllProjectDetails> details)
	{
		List<AllProjectDetails> projDetails=new ArrayList<AllProjectDetails>();
		for(AllProjectDetails detail:details)
		{
			long totalTask=(long) this.sessionFactory.getCurrentSession()
					.createQuery("select count(*) from Task t where t.project_id=:id").setParameter("id", detail.getProject_id())
					.uniqueResult();
			long completedTask=(long) this.sessionFactory.getCurrentSession()
					.createQuery("select count(*) from Task t where t.project_id=:id and (t.end_date>=curdate() or t.task_status='Completed')").setParameter("id", detail.getProject_id())
					.uniqueResult();
			detail.setTotal_task(totalTask);
			detail.setCompleted_task(completedTask);
			projDetails.add(detail);
		}
		
		return projDetails;
	}
}
