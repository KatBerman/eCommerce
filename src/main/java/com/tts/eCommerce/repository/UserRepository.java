package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.eCommerce.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	List<User> findUsersByRole(String role);
	User findByEmail(String email);
}
