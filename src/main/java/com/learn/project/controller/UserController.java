package com.learn.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.project.entity.User;

import com.learn.project.service.UserServiceImplementation;

@Controller
public class UserController 
{
	
	@Autowired
	UserServiceImplementation service;
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user)
	{
	
		service.addUser(user);
		return "login";
		
	}
	@PostMapping("/login")
	public String userlogin(@RequestParam("email")String email,@RequestParam("password")String password)
	{
		service.checkUserExcist(email, password);
		return null;
		
	}
	@PostMapping("/sendemail")
	public void sendEmail(@RequestParam("sentTo")String sentTo,@RequestParam("subject")String subject,@RequestParam("body") String body)
	{
		
		System.out.println(service.emailSend(sentTo, subject, body));
	}
}
