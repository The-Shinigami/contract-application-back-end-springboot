package org.lsi.services;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Proprety;
import org.lsi.repository.PropretyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropretyServiceImpl implements PropretyService{
	
	@Autowired
	PropretyRepository propRep;

	@Override
	public void addProprety(Proprety p) {
		// TODO Auto-generated method stub
		propRep.save(p);
		
	}

	@Override
	public Proprety updateProprety(String id, Proprety p) {
		// TODO Auto-generated method stub
		Proprety existingProprety = propRep.findById(id).orElse(null);
		existingProprety.setOwner(p.getOwner());;
		existingProprety.setDesc(p.getDesc());;
		existingProprety.setTypePrp(p.getTypePrp());
		propRep.save(existingProprety);
		return existingProprety;
	}

	@Override
	public List<Proprety> getAll() {
		// TODO Auto-generated method stub
		return propRep.findAll();
	}

	@Override
	public Optional<Proprety> getById(String id) {
		// TODO Auto-generated method stub
		return propRep.findById(id);
	}

	@Override
	public List<Proprety> getByUserId(String id) {
		
		return propRep.findByOwnerId(id);
	}

}
