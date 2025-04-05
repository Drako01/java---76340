package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.apis.UserRestApi;
import com.coderhouse.interfaces.UserRestInterface;
import com.coderhouse.models.User;

@Service
public class UserService implements UserRestInterface{

	@Autowired
	private UserRestApi urs;
	
	@Override
	public List<User> getAllUsers() {
		return urs.getAllUsers();
	}

	@Override
	public User getUserById(String id) {
		return urs.getUserById(id);
	}

	@Override
	public User addUser(User user) {
		return urs.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return urs.updateUser(user);
	}

	@Override
	public void deleteUserById(String id) {
		urs.deleteUserById(id);		
	}

}
