package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.iiht.dao.UserDAO;
import com.cts.iiht.model.Users;

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
	public void addUser(Users user) {
		 userDAO.addUser(user);
		
	}
	
	/*@Autowired
	public void updateUser(Users user,String userID) {
		 userDAO.updateUser(user,userID);
		
	}
	
	@Autowired
	public Users findById(int id)
	{
		return userDAO.findById(id);
	}
	
	/*@Autowired
	public Users findByFirstName(String first_name)
	{
		return userDAO.findByFirstName(firstame);
	}*/
}
