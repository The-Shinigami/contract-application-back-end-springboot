package org.lsi.repositories;

import java.util.Optional;

import org.lsi.entities.Token;
import org.lsi.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface TokenRepository extends MongoRepository<Token, String>{
Boolean existsByUser(User user);
Optional<Token> findByUser(User user);
Optional<Token> findByUserAndToken(User user , String token);
Optional<Token> findByToken(String token);
}
