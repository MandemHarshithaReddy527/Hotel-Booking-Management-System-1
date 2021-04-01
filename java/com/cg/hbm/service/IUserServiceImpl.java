package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IUserRepository;
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserNotFoundException;

@Service("uService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository uDao;

	@Override
	public List<User> addUser(User user) {
		uDao.saveAndFlush(user);
		return uDao.findAll();
	}

	@Override
	public User updateUser(User user) {
		uDao.saveAndFlush(user);
		return user;
	}

	@Override
	public List<User> removeUser(Integer user_id) throws UserNotFoundException{
		uDao.deleteById(user_id);
		return uDao.findAll();
	}

	@Override
	public List<User> showAllUsers() {
		return uDao.findAll();
	}

	@Override
	public User showUser(Integer user_id) {
		if(uDao.findById(user_id).isPresent()) {
			return uDao.findById(user_id).get();
		}
		else {
			return null;
		}
	
	}

}
