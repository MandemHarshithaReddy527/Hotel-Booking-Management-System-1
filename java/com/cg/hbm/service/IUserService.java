package com.cg.hbm.service;

import java.util.List;

import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserNotFoundException;

public interface IUserService {
	public List<User> addUser(User user);
	public User updateUser(User user);
	public List<User> removeUser(Integer user_id)  throws UserNotFoundException;
	public List<User> showAllUsers();
	public User showUser(Integer user_id) throws UserNotFoundException;
}
