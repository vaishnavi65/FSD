package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Users;
@ComponentScan("com.cts.iiht")
@Repository
@Transactional
public class UserDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@Autowired 
	Users user;
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		List<?> list = entityManager.createQuery("SELECT u FROM Users u order by u.employee_id asc").getResultList();
		return (List<Users>) list;
	}
	

	@SuppressWarnings("unchecked")
	public Users addUser(Users user) {
		entityManager.createNativeQuery("INSERT INTO Users (first_name, last_name,employee_id,project_id,task_id) VALUES (?,?,?,?,?)")
      .setParameter(1, user.getFirst_name())
      .setParameter(2, user.getLast_name())
      .setParameter(3, user.getEmployee_id())
      .setParameter(4, user.getProject_id())
      .setParameter(5, user.getTask_id())
      .executeUpdate();
		return user;
	}
	@SuppressWarnings("unchecked")
	public void updateUser(Users user) {
		entityManager.createNativeQuery("Update Users set first_name=?, last_name=?,employee_id=?,project_id=?,task_id=? where user_id=?")
	      .setParameter(1, user.getFirst_name())
	      .setParameter(2, user.getLast_name())
	      .setParameter(3, user.getEmployee_id())
	      .setParameter(4, user.getProject_id())
	      .setParameter(5, user.getTask_id())
	      .setParameter(6, user.getUser_id())
	      .executeUpdate();
	}
	
/*	@SuppressWarnings("unchecked")
	public Users findById(int id){
		Users user=new Users();
		user = (Users) entityManager.createQuery("SELECT u FROM Users u where u.user_id=:id").setParameter("id",id).getSingleResult();
		return user;
	}
	
/*@SuppressWarnings("unchecked")
	public Users findByFirstName(String first_name){
	Users user=new Users();
	
	List<?> list =entityManager.createQuery("SELECT u FROM Users u where u.first_name=:name").setParameter("name", first_name).getResultList();
	user=(Users) list.get(0);
	return user;
	}*/
	
} 
