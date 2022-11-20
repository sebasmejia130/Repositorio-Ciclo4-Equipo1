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
	public Optional<Usuario> consultarUsuario(Long id, String usuario) {
		if (id == null && usuario == null) {
			return Optional.empty();
		}
		
		if (id == null) {
			List<Usuario> lista = repositorio.findByUsuario(usuario);
			return Optional.of(lista.get(0));
		}
		return repositorio.findById(id);
	}
	
	@Override
	public Optional<Usuario> consultarUsuarioPorRol(String rol) {
		if (rol == null) {
			return Optional.empty();
		}	else {
			return repositorio.findByRol(rol);
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		Optional<Usuario> consultarParaCrear = repositorio.findById(usuario.getId());
		if (consultarParaCrear.isPresent()) {
			return null;
		}
		List<Usuario> usuarios = repositorio.findByUsuario(usuario.getLoginName());
		if (usuarios.size() > 0) {
			return usuarios.get(0);
		}
		return repositorio.insert(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		Optional<Usuario> consultarParaActualizar = repositorio.findById(usuario.getId());
		if (consultarParaActualizar.isPresent()) {
			return repositorio.save(usuario);
		}
		return null;
	}

	@Override
	public String eliminarUsuarioPorId(Long id) {
		Optional<Usuario> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "El registro ha sido eliminado correctamente";
		}
		return "La orden no se encontro, no se puede eliminar";
	}
}
