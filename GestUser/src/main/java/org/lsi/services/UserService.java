package org.lsi.services;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Users;
import org.lsi.request.SignupRequest;

public interface UserService {
     public Users save(Users users);
     public List<Users> getAll();
 	 public Users Update(String id,Users users);
 	 public Optional<Users> getById(String id);
 	 public Optional<Users> getByUsername(String username);
}
