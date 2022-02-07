package org.lsi.repositories;

import org.lsi.entities.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<Contract, String>{

}
