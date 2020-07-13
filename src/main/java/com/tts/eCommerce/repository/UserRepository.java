package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	public List<User> findUsersByRole(String role);
	public User findByEmail(String email);
}
