package com.tucita.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

}
