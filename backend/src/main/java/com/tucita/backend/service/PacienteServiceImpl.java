package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<Paciente> consultarPacientePorId(Long id) {
		if (id == null) {
			return Optional.empty();
		} else {
			return repositorio.findById(id);
		}
	}

	@Override
	public Paciente crearPaciente(Paciente paciente) {
		Optional<Paciente> consultarParaCrear = repositorio.findById(paciente.getCodigoPaciente());
		if (consultarParaCrear.isPresent()) {
			return null;
		}
		List<Paciente> pacientes = repositorio.findByNombres(paciente.getNombres());
		if (pacientes.size() > 0) {
			return pacientes.get(0);
		}
		return repositorio.insert(paciente);
	}

	@Override
	public Paciente actualizarPaciente(Paciente paciente) {
		Optional<Paciente> consultarParaActualizar = repositorio.findById(paciente.getCodigoPaciente());
		if (consultarParaActualizar.isPresent()) {
			return repositorio.save(paciente);
		} else {
			return null;
		}
	}

	@Override
	public String eliminarPacientePorId(Long id) {
		Optional<Paciente> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "Registro eliminado correctamente";
		}
		return "Resgistro no encontrado, no se puede eliminar";
	}
}
