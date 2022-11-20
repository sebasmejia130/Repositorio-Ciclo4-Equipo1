package com.tucita.medicalteam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tucita.medicalteam.model.MedicoGeneral;

@Repository
public interface MedicoGeneralRepository extends MongoRepository<MedicoGeneral, Long> {
	
	@Query("{nombreMedico:?0}")
    List<MedicoGeneral> findByNombre(String nombreMedico);
	

}
