package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Token;
import com.example.demo.models.User;

public interface TokenRepository extends MongoRepository<Token, String>{
	Boolean existsByUser(User user);

Optional<User> findByUser(User user);
	
//	Optional<Token> findByUser(User user);
}
