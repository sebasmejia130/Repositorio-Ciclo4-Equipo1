package com.tucita.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Remision;

@Repository
public interface RemisioRepository extends MongoRepository<Remision, Long>{

}
