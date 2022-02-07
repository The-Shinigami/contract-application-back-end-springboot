package org.lsi.repository;

import java.util.List;

import org.lsi.entities.Proprety;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropretyRepository extends MongoRepository<Proprety, String>{

	List<Proprety> findByOwnerId(String id);

}
