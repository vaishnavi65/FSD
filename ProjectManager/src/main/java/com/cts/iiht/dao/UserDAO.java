package com.cts.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.model.Users;

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
	public void addUser(Users user) {
		entityManager.createNativeQuery("INSERT INTO Users (first_name, last_name,employee_id,project_id,task_id) VALUES (?,?,?,?,?)")
      .setParameter(1, user.getFirst_name())
      .setParameter(2, user.getLast_name())
      .setParameter(3, user.getEmployee_id())
      .setParameter(4, user.getProject_id())
      .setParameter(5, user.getTask_id())
      .executeUpdate();
	}
	/*@SuppressWarnings("unchecked")
	public void updateUser(Users user,String userID) {
		int id=Integer.parseInt(userID);
		Users currentUser = findById(id);
		if(currentUser!=null)
		{
			currentUser.setFirst_name(user.getFirst_name());
			currentUser.setLast_name(user.getLast_name());
			currentUser.setEmployee_id(user.getEmployee_id());
		}
		
		entityManager.merge(currentUser);
		
	}
	
	@SuppressWarnings("unchecked")
	public Users findById(int id){
		Users user = (Users) entityManager.createQuery("SELECT u FROM Users u where u.employee_id=:id").setParameter("id",id).getSingleResult();
		return user;
	}
	
/*	@SuppressWarnings("unchecked")
	public Users findByFirstName(String first_name){
		Users user = (Users) entityManager.createQuery("SELECT u FROM Users u where u.first_name=:first_name").setParameter("first_name", first_name).getSingleResult();
		return user;
	}
	*/
} 
