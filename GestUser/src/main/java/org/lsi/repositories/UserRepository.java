package org.lsi.repositories;

import org.lsi.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String>{
    public Users findByUsername(String username);
    public boolean existsByUsername(String username);
}
