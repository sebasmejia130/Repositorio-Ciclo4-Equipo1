package com.tucita.medicalteam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tucita.medicalteam.model.OrdenesRemisiones;

@Repository 
public interface OrdenesRemisionesRepository extends MongoRepository<OrdenesRemisiones, Long>{

}
