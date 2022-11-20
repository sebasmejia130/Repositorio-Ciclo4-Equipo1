package com.tucita.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, Long>{
	@Query("{area:'?0'}")
    List<Cita> findByArea(String area);
	
	@Query("{medicoId:?0}")
    Optional<Cita> findByMedico(Long medicoId);
}
