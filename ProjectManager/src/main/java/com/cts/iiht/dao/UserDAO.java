package com.cts.iiht.dao;

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
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL order by u.first_name asc").list();
		return (List<Users>) list;
	}
	@SuppressWarnings("unchecked")
	public List<Users> serachByLName() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL order by u.last_name asc").list();
		return (List<Users>) list;
	}
	@SuppressWarnings("unchecked")
	public List<Users> serachById() {
		List<?> list =sessionFactory.getCurrentSession().createQuery("SELECT u FROM Users u where u.first_name is not NULL order by u.employee_id asc").list();
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
		/*if(!list.isEmpty())
		{
			logger.debug("the record that is being deleted is "+list.get(0).getFirst_name()+" "+list.get(0).getLast_name());
			this.sessionFactory.getCurrentSession().delete(list.get(0));;
		}*/
		
		
		
	}
	/*
	@SuppressWarnings("unchecked")
	public Users findById(int id){
		Users user =(Users) sessionFactory.getCurrentSession()
					.createQuery("SELECT u FROM Users u where u.employee_id=:id")
							.setParameter("id", id).list();
			return user;
	}
/*	
@SuppressWarnings("unchecked")
	public List<Users> findByFirstName(String first_name){
	List<?> list =(List<?>) sessionFactory.getCurrentSession()
					.createQuery("SELECT u FROM Users u where u.first_name LIKE :pname")
							.setParameter("pname", "%"+first_name+"%").list();
			return (List<Users>) list;
	}*/
	
} 
