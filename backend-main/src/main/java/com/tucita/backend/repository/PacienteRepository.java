package com.tucita.backend.repository;

import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Long>{

}
