package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Task;

@Repository
@Transactional
public class ParentTaskDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ParentTask> getAllParentTask() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("SELECT parent FROM ParentTask parent where parent_task is not null order by parent_id asc").list();
		return (List<ParentTask>) list;
	}
	
	@SuppressWarnings("unchecked")
	public void addParentTask(AllTaskDetails taskDetails) {
		List<ParentTask> taskList=(List<ParentTask>)this.sessionFactory.getCurrentSession()
				.createQuery("select t from ParentTask t where t.parent_task=:name")
				.setParameter("name",taskDetails.getParentTaskName()).list();
		if(taskList.isEmpty())
		{
			ParentTask pt=new ParentTask();
			pt.setParent_task(taskDetails.getParentTaskName());
			sessionFactory.getCurrentSession().save(pt);
		}
		else
		{
			ParentTask pt=new ParentTask();
			pt.setParent_id(taskList.get(0).getParent_id());
			pt.setParent_task(taskDetails.getParentTaskName());
			updateParentTask(pt);
		}
	}
	@SuppressWarnings("unchecked")
	public void updateParentTask(ParentTask parentTask) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE ParentTask p set p.parent_task=:name where p.parent_id=:id")
		.setParameter("name",parentTask.getParent_task())
		.setParameter("id",parentTask.getParent_id())
		.executeUpdate();
		
	}
	
	public int getPTIDByPTName(String ptName) {
	 int pId=0;
	  
	 @SuppressWarnings("unchecked")
	List<ParentTask> list = (List<ParentTask>)sessionFactory.getCurrentSession()
			 .createQuery("SELECT p FROM ParentTask p where p.parent_task=:name order by parent_id asc")
			 .setParameter("name", ptName).list();
		
		if(list.isEmpty())
		{
			return pId;
		}
		else
		{
			pId=list.get(0).getParent_id();
		}
		return pId;
	}
	
	public String getPTNameByPTId(int id) {
		 String  name="";
		  
		 @SuppressWarnings("unchecked")
		List<ParentTask> list = (List<ParentTask>)sessionFactory.getCurrentSession()
				 .createQuery("SELECT p FROM ParentTask p where p.parent_id=:id order by parent_task asc")
				 .setParameter("id", id).list();
			
			if(list.isEmpty())
			{
				return name;
			}
			else
			{
				name=list.get(0).getParent_task();
			}
			return name;
		}
} 
