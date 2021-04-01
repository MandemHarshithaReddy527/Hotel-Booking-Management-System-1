package com.cg.hbm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService uService;
	
	@GetMapping
	public List<User> fetchAllUsers(){
		return uService.showAllUsers();
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> viewUser(@PathVariable("userid")int userid) throws UserNotFoundException {
		User u =  uService.showUser(userid);
		if(u!=null) {
			return new ResponseEntity<User>(u,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public  List<User> saveUser(@RequestBody User user) {
		return uService.addUser(user);
	}
	
	@DeleteMapping("/{userid}")
	public List<User> removeUser(@PathVariable int userid) throws UserNotFoundException{
		return uService.removeUser(userid);
	}
	
	@PutMapping
	public User updateUserData(@RequestBody User user){
		return  uService.updateUser(user);
		
	}	
}