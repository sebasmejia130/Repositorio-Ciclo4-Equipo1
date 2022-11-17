package com.tucita.medicalteam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tucita.medicalteam.model.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Long>{

}
