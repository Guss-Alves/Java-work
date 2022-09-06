package com.loginandregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.loginandregistration.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//SEARCH FOR A EMAIL
	Optional<User> findByEmail(String email);
	
	
}
