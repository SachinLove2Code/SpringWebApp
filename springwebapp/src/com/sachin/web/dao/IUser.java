package com.sachin.web.dao;

import java.util.List;

import com.sachin.web.beans.User;

public interface IUser {
	
	boolean insert(User user);

	boolean existsUsername(String username);

	List<User> getUsers();
	
}
