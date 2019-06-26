package com.cts.iiht.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.controller.ProjectManagerController;
import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Task;
import com.cts.iiht.model.Users;
@ComponentScan("com.cts.iiht")
@Repository
@Transactional
public class UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired 
	Users user;
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL").list();
		return (List<Users>) list;
	}
	@SuppressWarnings("unchecked")
	public List<Users> serachByFName() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL group by u.employee_id order by u.first_name asc").list();
		return (List<Users>) list;
	}
	@SuppressWarnings("unchecked")
	public List<Users> serachByLName() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL group by u.employee_id order by u.last_name asc").list();
		return (List<Users>) list;
	}
	@SuppressWarnings("unchecked")
	public List<Users> serachById() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL group by u.employee_id order by u.employee_id asc").list();
		return (List<Users>) list;
	}
	
	public List<Users> searchManagers() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not null group by u.employee_id order by u.employee_id asc").list();
		return (List<Users>) list;
	}

	@SuppressWarnings("unchecked")
	public Users addUser(Users user) {
		List<?> list =sessionFactory.getCurrentSession()
				.createQuery("SELECT u FROM Users u where u.employee_id=:id")
				.setParameter("id", user.getEmployee_id()).list();
		if(list.isEmpty())
		{
		sessionFactory.getCurrentSession().save(user);
		}
		else 
		{
			updateUser(user);
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public void addUser(AllProjectDetails project) {
		List<Users> list =(List<Users>)sessionFactory.getCurrentSession()
				.createQuery("SELECT u FROM Users u where u.project_id=:id")
				.setParameter("id",project.getProject_id()).list();
		if(list.isEmpty())
		{
			int empId=(int) this.sessionFactory.getCurrentSession()
					.createQuery("select u.employee_id from Users u where u.first_name=:name").setParameter("name", project.getManager_first_name())
					.uniqueResult();
			Users user=new Users();
			user.setEmployee_id(empId);
			user.setFirst_name(project.getManager_first_name());
			user.setLast_name(project.getManager_last_name());
			user.setProject_id(project.getProject_id());
		sessionFactory.getCurrentSession().save(user);
		}
		else 
		{
			Users userToUpdate=list.get(0);
			userToUpdate.setFirst_name(project.getManager_first_name());
			userToUpdate.setLast_name(project.getManager_last_name());
			userToUpdate.setProject_id(project.getProject_id());
			updateUser(userToUpdate);
		}
		//return user;
	}
	
	@SuppressWarnings("unchecked")
	public void updateUser(Users user) {
		this.sessionFactory.getCurrentSession()
		.createQuery("UPDATE Users u set u.first_name=:first , u.last_name=:last where u.employee_id=:id")
		.setParameter("first", user.getFirst_name()).setParameter("last", user.getLast_name())
		.setParameter("id", user.getEmployee_id())
		.executeUpdate();
		
	}
	
	public void deleteUser(Users user) {
		this.sessionFactory.getCurrentSession()
		.createQuery("DELETE FROM Users u where u.first_name=:first and u.last_name=:last")
		.setParameter("first", user.getFirst_name()).setParameter("last", user.getLast_name())
		.executeUpdate();
				
	}
	public List<AllProjectDetails> getManagerDetails(List<AllProjectDetails> details)
	{
		List<AllProjectDetails> returnList=new ArrayList<>();
		for (AllProjectDetails detail:details)
		{
			String managerName=(String) this.sessionFactory.getCurrentSession()
					.createQuery("select concat(u.first_name,' ',u.last_name) from Users u where u.project_id=:id")
					.setParameter("id", detail.getProject_id()).uniqueResult();
			if(managerName!=""&&managerName!=null)
			{
				String[] names=managerName.split(" ");
				detail.setManager_first_name(names[0]);
				detail.setManager_last_name(names[1]);
			}
			returnList.add(detail);
			
		}
		return returnList;
	}
	
	public void updateUserInfoFromProjectDetails(AllProjectDetails detail)
	{
		addUser(detail);
	}
	
} 
