package org.lsi.controller;

import java.util.List;

import org.lsi.entities.Complaint;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.entities.User;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
import org.lsi.services.ComplaintService;
import org.lsi.services.EmailSenderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reclamation")
public class ComplaintController {

	@Autowired
	ComplaintService compServ;
	
	@Autowired
	private EmailSenderServiceImp service;

	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/listComplaints")
	public ResponseEntity<List<Complaint>>listComplaints(@RequestHeader("Authorization") String token) throws Exception{
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){
		return new ResponseEntity<List<Complaint>>(compServ.getAll(), HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping("/addComplaint")
	public ResponseEntity<Complaint>addComplaint(@RequestHeader("Authorization") String token,@RequestBody Complaint c) throws Exception{
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_USER;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){
		compServ.addComplaint(c);
		return new ResponseEntity<Complaint>(c, HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping("/sendResponse")
	public ResponseEntity<Complaint>sendResponse(@RequestHeader("Authorization") String token,@RequestBody Complaint c) throws Exception{
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){
		service.sendSimpleEmail(c.getEmail(),
				c.getReponse(),
				"Reponse a votre reclamation");
		compServ.addComplaint(c);
		return new ResponseEntity<Complaint>(c, HttpStatus.OK);
		} 
		return null;
	}
	

}
