package com.learn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.learn.project.entity.User;
import com.learn.project.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepository repos;
	
	@Autowired
	JavaMailSender javamailsender;

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		repos.save(user);
		return "User Added Sucessfull";
	}


	@Override
	public User checkUserExcist(String email, String password) {
		// TODO Auto-generated method stub
		User user= repos.getByEmail(email);
		if(user.getPassword().equals(password))
		{
			return user;
		}
		return null;

	}


	@Override
	public String emailSend(String sentTo, String subject, String body) {
		// TODO Auto-generated method stub
		/*		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(sentTo);
		mail.setSubject(subject);
		mail.setText(body);
		mail.setFrom("sudhakar2001dpi@gmail.com");     */

		MimeMessage mimemessage=javamailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimemessage,"utf-8");
		try
		{
			helper.setText(body,true);
			helper.setTo(sentTo);
			helper.setSubject(subject);
			helper.setFrom("sudhakar2001dpi@gmail.com");
			javamailsender.send(mimemessage);
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Email Sent Sucessfully";
	}

}
