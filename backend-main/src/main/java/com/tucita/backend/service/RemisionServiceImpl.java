package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.backend.model.Cita;
import com.tucita.backend.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {
	@Autowired
	private CitaRepository repositorio;

	@Override
	public List<Cita> consultarCitas() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Cita> consultarCitaPorId(Long id) {
		if (id == null) {
			return Optional.empty();
		}
		return repositorio.findById(id);
	}

	@Override
	public Cita crearCita(Cita cita) {
		
		return null;
	}

	@Override
	public Cita actualizarCita(Cita cita) {
		Optional<Cita> consultarParaActualizar = repositorio.findById(cita.getId());
		if (consultarParaActualizar.isPresent()) {
			return repositorio.save(cita);
		} else {
			return null;
		}
	}

	@Override
	public String eliminarCitaPorId(Long id) {
		Optional<Cita> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "REgistro eliminado correctamente";
		} else {
			return "Registro no encontrado, no se puede eliminar";
		}

	}

}
