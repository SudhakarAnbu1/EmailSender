package com.learn.project.service;

import com.learn.project.entity.User;

public interface UserService 
{
	public String addUser(User user);
	
	public User checkUserExcist(String email, String password);
	
	public String emailSend(String sentTo, String subject, String body);
}
