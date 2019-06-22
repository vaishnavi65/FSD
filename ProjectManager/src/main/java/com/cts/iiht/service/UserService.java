package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.dao.UserDAO;
import com.cts.iiht.model.Users;
@ComponentScan("com.cts.iiht")
@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Users user;
	
	public List<Users> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Autowired
	public Users addUser(Users user) {
		 return userDAO.addUser(user);
		
	}
	
	@Autowired
	public void updateUser(Users user) {
		 userDAO.updateUser(user);
		
	}
	
	/*@Autowired
	public Users findById(int id)
	{
		return userDAO.findById(id);
	}
	
	/*@Autowired
	public Users findByFirstName(String first_name)
	{
		return userDAO.findByFirstName(first_name);
	}*/
}
