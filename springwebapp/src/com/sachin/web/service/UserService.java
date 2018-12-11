package com.sachin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.sachin.web.beans.User;
import com.sachin.web.dao.IUser;
import com.sachin.web.dao.UserDao;


@Service("userService")
public class UserService {

	private IUser iUser = new UserDao();

	@Autowired
	public void setiUser(IUser iUser) {
		this.iUser = iUser;
	}

	public void insertUser(User user) {
		iUser.insert(user);
	}

	public boolean exists(String username) {
		
		return iUser.existsUsername(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		
		return iUser.getUsers();
	}
	
	
}
