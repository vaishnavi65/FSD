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
	public List<Users> serachByFName() {
		return userDAO.serachByFName();
	}
	public List<Users> serachByLName() {
		return userDAO.serachByLName();
	}
	public List<Users> serachById() {
		return userDAO.serachById();
	}

	@Autowired
	public Users addUser(Users user) {
		 return userDAO.addUser(user);
		
	}
	
	@Autowired
	public void updateUser(Users user) {
		 userDAO.updateUser(user);
		
	}
	
	@Autowired
	public void deleteUser(Users user) {
		 userDAO.deleteUser(user);
		
	}
	@Autowired
	public List<Users> searchManagers() {
		return userDAO.searchManagers();
	}
}
