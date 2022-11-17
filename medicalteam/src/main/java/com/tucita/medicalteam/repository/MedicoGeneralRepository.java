package com.tucita.medicalteam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tucita.medicalteam.model.MedicoGeneral;

@Repository
public interface MedicoGeneralRepository extends MongoRepository<MedicoGeneral, Long> {

}
