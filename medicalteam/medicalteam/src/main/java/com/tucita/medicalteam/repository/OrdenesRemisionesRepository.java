package com.tucita.medicalteam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.tucita.medicalteam.model.OrdenesRemisiones;

@Repository 
public interface OrdenesRemisionesRepository extends MongoRepository<OrdenesRemisiones, Long>{
	
	@Query("{tipoExamen:'?0'}")
    List<OrdenesRemisiones> findByTipoExamen(String tipoExamen);

}
