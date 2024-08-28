package com.learn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.project.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	public User getByEmail(String email);
}
