package com.tucita.backend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tucita.backend.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {
	@Query("{loginName:'?0'}")
    List<Usuario> findByUsuario(String loginName);
	
	@Query("{rol:'?0'}")
    Optional<Usuario> findByRol(String rol);
}
