package com.tucita.backend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Medico;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, Long>{
	@Query("{nombres:'?0'}")
    List<Medico> findByNombres(String nombres);
	
	@Query("{area:'?0'}")
    Optional<Medico> findByArea(String area);
}
