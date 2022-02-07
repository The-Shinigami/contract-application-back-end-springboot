package org.lsi.repositories;

import java.util.List;

import org.lsi.entities.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<Complaint,String>{
	public List<Complaint> findByEmail(String email);

}
