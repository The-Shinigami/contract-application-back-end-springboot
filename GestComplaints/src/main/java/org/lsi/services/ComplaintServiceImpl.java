package org.lsi.services;

import java.util.List;

import org.lsi.entities.Complaint;
import org.lsi.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired
	ComplaintRepository compRep;

	@Override
	public void addComplaint(Complaint c) {
		compRep.save(c);	
	}

	@Override
	public List<Complaint> getAll() {
		return compRep.findAll();
	}

}
