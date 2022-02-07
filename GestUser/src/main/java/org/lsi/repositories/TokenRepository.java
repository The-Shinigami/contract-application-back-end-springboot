package org.lsi.repositories;

import java.util.Optional;


import org.lsi.entities.Token;
import org.lsi.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface TokenRepository extends MongoRepository<Token, String>{
Boolean existsByUser(Users user);
Optional<Token> findByUser(Users user);
Optional<Token> findByUserAndToken(Users user , String token);
Optional<Token> findByToken(String token);
	
}
