package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tucita.backend.model.Usuario;
import com.tucita.backend.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public List<Usuario> consultarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Usuario> consultarUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

}
