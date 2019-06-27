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
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;

@Repository
@Transactional
public class ProjectDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
    private UserDAO userDAO;
	@Autowired
    private TaskDAO taskDAO;
	@SuppressWarnings("unchecked")
	public List<AllProjectDetails> getAllProjects() {
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status!='Suspended' order by p.project_id asc").list();
		List<AllProjectDetails> projectDeatilList=new ArrayList<>();
		
		if (!list.isEmpty()) 
		{
			projectDeatilList=convertToProjDEtailList(list);
			projectDeatilList = userDAO.getManagerDetails(projectDeatilList);
			projectDeatilList = taskDAO.getTaskDetails(projectDeatilList);
		}
		return projectDeatilList;
	}
	
	
	private List<AllProjectDetails> convertToProjDEtailList(List<Project> list) {
		List<AllProjectDetails> projDetailList=new ArrayList<AllProjectDetails>();
		
			for(Project proj:list)
			{
				AllProjectDetails projDetail=new AllProjectDetails();
				projDetail.setProject(proj.getProject());
				projDetail.setEnd_date(proj.getEnd_date());
				projDetail.setPriority(proj.getPriority());
				projDetail.setProject_id(proj.getProject_id());
				projDetail.setStart_date(proj.getStart_date());
				projDetail.setStatus(proj.getStatus());
				projDetailList.add(projDetail);
				
			}
		
		return projDetailList;
	}
	public List<AllProjectDetails> sortBySDate() {
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status!='Suspended' order by p.start_date asc").list();
List<AllProjectDetails> projectDeatilList=new ArrayList<>();
		
		if (!list.isEmpty()) 
		{
			projectDeatilList=convertToProjDEtailList(list);
			projectDeatilList = userDAO.getManagerDetails(projectDeatilList);
			projectDeatilList = taskDAO.getTaskDetails(projectDeatilList);
		}
		return projectDeatilList;
	}
	public List<AllProjectDetails> sortByEDate() {
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status!='Suspended' order by p.end_date asc").list();
        List<AllProjectDetails> projectDeatilList=new ArrayList<>();
		
		if (!list.isEmpty()) 
		{
			projectDeatilList=convertToProjDEtailList(list);
			projectDeatilList = userDAO.getManagerDetails(projectDeatilList);
			projectDeatilList = taskDAO.getTaskDetails(projectDeatilList);
		}
		return projectDeatilList;
	}
	public List<AllProjectDetails> sortByPriority() {
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status!='Suspended' order by p.priority asc").list();
        List<AllProjectDetails> projectDeatilList=new ArrayList<>();
		
		if (!list.isEmpty()) 
		{
			projectDeatilList=convertToProjDEtailList(list);
			projectDeatilList = userDAO.getManagerDetails(projectDeatilList);
			projectDeatilList = taskDAO.getTaskDetails(projectDeatilList);
		}
		return projectDeatilList;
	}
	public List<AllProjectDetails> sortByCompletion() {
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id is not null and p.status='Completed' order by p.start_date asc").list();
        List<AllProjectDetails> projectDeatilList=new ArrayList<>();
		
		if (!list.isEmpty()) 
		{
			projectDeatilList=convertToProjDEtailList(list);
			projectDeatilList = userDAO.getManagerDetails(projectDeatilList);
			projectDeatilList = taskDAO.getTaskDetails(projectDeatilList);
		}
		return projectDeatilList;
	}
	@SuppressWarnings("unchecked")
	public void addProject(AllProjectDetails projectDetail) {
		List<Project> list =(List<Project>)sessionFactory.getCurrentSession()
				.createQuery("SELECT p FROM Project p where p.project=:proj")
				.setParameter("proj", projectDetail.getProject()).list();
		if(list.isEmpty())
		{
			Project proj=new Project();
			proj.setEnd_date(projectDetail.getEnd_date());
			proj.setPriority(projectDetail.getPriority());
			proj.setProject(projectDetail.getProject());
			proj.setStart_date(projectDetail.getStart_date());
			proj.setStatus(projectDetail.getStatus());
		sessionFactory.getCurrentSession().save(proj);
		int projId=(int) this.sessionFactory.getCurrentSession()
				.createQuery("SELECT p.project_id FROM Project p where p.project=:proj").setParameter("proj", proj.getProject())
				.uniqueResult();
		projectDetail.setProject_id(projId);
		userDAO.addUser(projectDetail);
		}
		else
		{
			projectDetail.setProject_id(list.get(0).getProject_id());
			updateProject(projectDetail);
		}
		
	}
	@SuppressWarnings("unchecked")
	public void updateProject(AllProjectDetails projectDetail) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Project p set p.start_date=:sDate,p.end_date=:eDate,p.priority=:priority,p.status=:status where p.project=:proj")
		.setParameter("sDate", projectDetail.getStart_date()).setParameter("eDate", projectDetail.getEnd_date())
		.setParameter("priority", projectDetail.getPriority()).setParameter("status", projectDetail.getStatus())
		.setParameter("proj", projectDetail.getProject()).executeUpdate();
		int projId=(int) this.sessionFactory.getCurrentSession()
				.createQuery("SELECT p.project_id FROM Project p where p.project=:proj").setParameter("proj", projectDetail.getProject())
				.uniqueResult();
		projectDetail.setProject_id(projId);
		userDAO.updateUserInfoFromProjectDetails(projectDetail);
		
	}
	public void suspendProject(Project project) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Project p set p.status=\'Suspended\' where p.project=:proj")
		.setParameter("proj", project.getProject()).executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	public int getProjectIDByName(String projName) {
		int id=0;
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project=:name order by p.project asc")
				.setParameter("name", projName).list();
		if(list.isEmpty())
		{
			return id;
		}
		else
		{
			id=list.get(0).getProject_id();
		}
		
		return id;
	}
	@SuppressWarnings("unchecked")
	public String getProjectNameById(int id) {
		String name="";
		List<Project> list = (List<Project>)sessionFactory.getCurrentSession().createQuery("SELECT p FROM Project p where p.project_id=:id order by p.project asc")
				             .setParameter("id", id).list();
		if(list.isEmpty())
		{
			return name;
		}
		else
		{
			name=list.get(0).getProject();
		}
		
		return name;
	}
} 