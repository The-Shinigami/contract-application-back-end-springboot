package org.lsi.services;

import java.util.List;
import java.util.Optional;
import org.lsi.entities.Users;
import org.lsi.repositories.UserRepository;
import org.lsi.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserRepository userRep;

	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		users = userRep.save(users);
		return users;	
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}

	@Override
	public Users Update(String id,Users users) {
		// TODO Auto-generated method stub
		Users existingUser = userRep.findById(id).orElse(null);
		existingUser.setNom(users.getNom());
		existingUser.setPrenom(users.getPrenom());
		existingUser.setCIN(users.getCIN());
		existingUser.setEmail(users.getUsername());
		if(users.getPassword() != null && users.getPassword().length() != 0) {
			System.out.println("Password");
		existingUser.setPassword(users.getPassword());
		}
		existingUser.setTel(users.getTel());
		existingUser.setRoles(users.getRoles());
		userRep.save(existingUser);
		return existingUser;
	}


	@Override
	public Optional<Users> getById(String id) {
		// TODO Auto-generated method stub
		return userRep.findById(id);
	}

	@Override
	public Optional<Users> getByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRep.findByUsername(username));
	}

	
	

}
