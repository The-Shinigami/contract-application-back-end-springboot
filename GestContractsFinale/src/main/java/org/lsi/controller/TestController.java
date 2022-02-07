package org.lsi.controller;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import org.lsi.controller.dto.AddLandDto;
import org.lsi.controller.dto.PropretiesDto;
import org.lsi.entities.Contract;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.entities.User;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
import org.lsi.service.TestService;
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
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;

@RestController
@RequestMapping("/api/contrats")
public class TestController {
	
	@Autowired
	TestService testServ;

	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//To add in db and blockchain
	@PostMapping("/addContract")
    public Contract addLand(@RequestHeader("Authorization") String token,@RequestBody Contract c) throws Exception {
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){	
          return testServ.addLand(
                c.getBuyer(),
                c.getSeller(),
                c.getCost(),
                c.getDesc(),
                c.getProp(),
                c.getDate());
		}
		return null;
    }

	//List From blockchain
	@GetMapping("/listAll")
    public ResponseEntity<List<AddLandDto>>listLand(@RequestHeader("Authorization") String token) throws Exception {
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){	
		int lenght = getCountContract();
    	List<AddLandDto> contracts = new ArrayList<AddLandDto>();
        for(int i = 1 ;i < lenght+1 ;i++) {
        	AddLandDto msg = mapToLandDto(testServ.Propreties(BigInteger.valueOf(i)) );
        	contracts.add(new AddLandDto(msg.getNumeroContract(),msg.getIdProprety(), msg.getOwnerLand(), msg.getBuyerLand(),msg.getCost(), msg.getDesc(),msg.getDate()));      	  
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
		}
		return null;
    }
	
	//From Blockchain
	 @PostMapping("listLand")
	    public AddLandDto getLand(@RequestBody PropretiesDto getLandDto) throws Exception {
	        return mapToLandDto(testServ.Propreties(
	                getLandDto.getParam0())
	        );
	    }

	    private AddLandDto mapToLandDto(Tuple7<String, String, String, String, BigInteger, String, String> tuple7) {
	        return new AddLandDto(tuple7.component1(), tuple7.component2(), tuple7.component3(),tuple7.component4(), tuple7.component5(), tuple7.component6(),tuple7.component7());
	    }
	
	@PostMapping("/countLand")
    public BigInteger countLand() throws Exception {
        return testServ.getNumberLands();
    }
	
	@GetMapping("/listLandOwner/{id}")
	public ResponseEntity<?>listLandOwner(@PathVariable String id) throws Exception{
		return new ResponseEntity<List<Contract>>(testServ.getAllOfOwner(id), HttpStatus.OK);
	}
	
	public int getCountContract() throws Exception {
        BigInteger msg =  testServ.getNumberLands();
        return msg.intValue();
    }
	
	//From database
	@GetMapping("/listContracts")
	public ResponseEntity<?>listContracts() throws Exception{
		return new ResponseEntity<List<Contract>>(testServ.getAll(), HttpStatus.OK);
	}

}
