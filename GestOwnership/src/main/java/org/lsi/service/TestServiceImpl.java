package org.lsi.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.lsi.entities.Contract;
import org.lsi.entities.User;
import org.lsi.repositories.ContractRepository;
import org.lsi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService{
	
	@Autowired 
	ContractRepository contRep;
	
	@Autowired
	UserRepository userRep;


@Override
public List<Contract> getAllOfBuyer(String id) {
    List<Contract> list=new ArrayList<Contract>();
    List<Contract> list1=contRep.findAll();
    for(int i=0;i<list1.size();i++) {
    	if(id.equals(list1.get(i).getBuyer().getId_user())) {
    		list.add(list1.get(i));
    	}
    }

	return list; 
}


@Override
public List<Contract> getAllOfSeller(String id) {
	  List<Contract> list=new ArrayList<Contract>();
	    List<Contract> list1=contRep.findAll();
	    for(int i=0;i<list1.size();i++) {
	    	if(id.equals(list1.get(i).getSeller().getId_user())) {
	    		list.add(list1.get(i));
	    	}
	    }
	return list; 
}
	 

}
