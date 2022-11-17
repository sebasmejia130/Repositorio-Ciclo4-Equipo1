package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.tucita.backend.model.Paciente;
import com.tucita.backend.repository.PacienteRepository;
@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repositorio;

	@Override
	public List<Paciente> consultarPacientes() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Paciente> consultarPersonaPorId(Long id) {
		if (id == null) {
			return Optional.empty();
		} else {
			return repositorio.findById(id);
		}
	}

	@Override
	public Paciente crearPaciente(Paciente paciente) {
		Optional<Paciente> consultarParaCrear = repositorio.findById(paciente.getId());
		if (consultarParaCrear.isPresent()) {
			return consultarParaCrear.get();
		} else {
			return repositorio.insert(paciente);
		}
	}

	@Override
	public Paciente actualizarPaciente(Paciente paciente) {
		Optional<Paciente> consultarParaCrear = repositorio.findById(paciente.getId());
		if (consultarParaCrear.isPresent()) {
			return consultarParaCrear.get();
		} else {
			return repositorio.insert(paciente);
		}
	}

	@Override
	public String eliminarPacientePorId(Long id) {
		Optional<Paciente> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "Registro eliminado correctamente";
		} else {
			return "Resgistro no encontrado, no se puede eliminar";
		}
	}

}
