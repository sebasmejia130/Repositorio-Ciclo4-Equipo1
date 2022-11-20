package com.tucita.backend.repository;

import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Paciente;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Long>{
	@Query("{nombres:'?0'}")
    List<Paciente> findByNombres(String nombres);
}
