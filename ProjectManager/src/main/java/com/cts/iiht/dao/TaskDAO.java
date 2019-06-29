package com.cts.iiht.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.Task;
@ComponentScan("com.cts.iiht")
@Repository
@Transactional
public class TaskDAO {
	@Autowired
	ProjectDAO projDAO;
	@Autowired
	ParentTaskDAO pTaskDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<AllTaskDetails> getAllTasks(AllTaskDetails taskDetails) {
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.project_id=:id order by t.task_id asc")
				.setParameter("id", projId)
				.list();
		List<AllTaskDetails> listWithProjDetails=new ArrayList<AllTaskDetails>() ;
		for (Task task:list)
		{
			
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByProjectId(projId));
			listWithProjDetails.add(detail);
		}
		return  listWithProjDetails;
	}
	public List<AllTaskDetails> getAllTasksSortBySDate(AllTaskDetails taskDetails) {
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		@SuppressWarnings("unchecked")
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.project_id=:id and t.task_status!='Completed' order by t.start_date asc")
				.setParameter("id", projId)
				.list();
		List<AllTaskDetails> listWithProjDetails=new ArrayList<AllTaskDetails>() ;
		for (Task task:list)
		{
			
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByProjectId(projId));
			listWithProjDetails.add(detail);
		}
		return  listWithProjDetails;
	}
	public List<AllTaskDetails> getAllTasksSortByEDate(AllTaskDetails taskDetails) {
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		@SuppressWarnings("unchecked")
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.project_id=:id and t.task_status!='Completed' order by t.end_date asc")
				.setParameter("id", projId)
				.list();
		List<AllTaskDetails> listWithProjDetails=new ArrayList<AllTaskDetails>() ;
		for (Task task:list)
		{
			
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByProjectId(projId));
			listWithProjDetails.add(detail);
		}
		return  listWithProjDetails;
	}
	public List<AllTaskDetails> getAllTasksSortByPriority(AllTaskDetails taskDetails) {
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		@SuppressWarnings("unchecked")
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.project_id=:id and t.task_status!='Completed' order by t.priority asc")
				.setParameter("id", projId)
				.list();
		List<AllTaskDetails> listWithProjDetails=new ArrayList<AllTaskDetails>() ;
		for (Task task:list)
		{
			
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByProjectId(projId));
			listWithProjDetails.add(detail);
		}
		return  listWithProjDetails;
	}
	public List<AllTaskDetails> getAllTasksSortByCompleted(AllTaskDetails taskDetails) {
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.project_id=:id and t.task_status=\'Completed\' order by t.task_id asc")
				.setParameter("id", projId)
				.list();
		List<AllTaskDetails> listWithProjDetails=new ArrayList<AllTaskDetails>() ;
		for (Task task:list)
		{
			
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByProjectId(projId));
			listWithProjDetails.add(detail);
		}
		return  listWithProjDetails;
	}
	@SuppressWarnings("unchecked")
	public void addTask(AllTaskDetails taskDetails) {
		
		int projId=projDAO.getProjectIDByName(taskDetails.getProjName());
		//int projId=1;
		//int ptId=1;
		int ptId=pTaskDAO.getPTIDByPTName(taskDetails.getParentTaskName());
		List<Task> taskList=(List<Task>)this.sessionFactory.getCurrentSession()
				.createQuery("select t from Task t where t.project_id=:id and t.task=:name")
				.setParameter("id",projId)
				.setParameter("name",taskDetails.getTask()).list();
		
		if(!taskList.isEmpty())
		{
			
			Task newTask=new Task();
			newTask.setTask_id(taskList.get(0).getTask_id());
			newTask.setParent_id(ptId);
			newTask.setProject_id(projId);
			newTask.setTask(taskDetails.getTask());
			newTask.setStart_date(taskDetails.getStart_date());
			newTask.setEnd_date(taskDetails.getEnd_date());
			newTask.setPriority(taskDetails.getPriority());
			
			updateTask(newTask);
			
		}
		else
		{
			
			Task newTask=new Task();
			newTask.setParent_id(ptId);
			newTask.setProject_id(projId);
			newTask.setTask(taskDetails.getTask());
			newTask.setStart_date(taskDetails.getStart_date());
			newTask.setEnd_date(taskDetails.getEnd_date());
			newTask.setPriority(taskDetails.getPriority());
			newTask.setTaskStatus(taskDetails.getTaskStatus());
			
			sessionFactory.getCurrentSession().save(newTask);
		}
	
		
	}
	@SuppressWarnings("unchecked")
	public void updateTask(Task task) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Task t set t.parent_task_id=:ptID , t.project_id=:projId,t.task=:task,"+
		             "t.start_date=:sDate,t.end_date=:eDate,t.priority=:priority,t.task_status=:taskStatus "+
				     "where t.task_id=:id")
		.setParameter("ptID",task.getParent_id())
		.setParameter("projId",task.getProject_id())
		.setParameter("task", task.getTask())
		.setParameter("sDate",task.getStart_date())
		.setParameter("eDate", task.getEnd_date())
		.setParameter("priority",task.getPriority())
		.setParameter("taskStatus", task.getTaskStatus())
		.setParameter("id", task.getTask_id())
		.executeUpdate();
		
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
	@SuppressWarnings("unchecked")
	public AllTaskDetails getTaskDetail(AllTaskDetails taskDetails) {
		List<Task> list = (List<Task>)sessionFactory.getCurrentSession().createQuery("SELECT t FROM Task t where t.task=:name order by t.start_date asc")
				.setParameter("name", taskDetails.getTask())
				.list();
		if(list.isEmpty())
		{
			return null;
		}
		else {
			Task task= list.get(0);
			AllTaskDetails detail=new AllTaskDetails();
			detail.setEnd_date(task.getEnd_date());
			detail.setParent_id(task.getParent_id());
			detail.setParentTaskName(pTaskDAO.getPTNameByPTId(task.getParent_id()));
			detail.setPriority(task.getPriority());
			detail.setProject_id(task.getProject_id());
			detail.setProjName(projDAO.getProjectNameById(task.getProject_id()));
			detail.setStart_date(task.getStart_date());
			detail.setTask(task.getTask());
			detail.setTask_id(task.getTask_id());
			detail.setTaskStatus(task.getTaskStatus());
			detail.setUserName(userDAO.getUserByTaskId(task.getTask_id()));
			return detail;
		}
		
	}
}
