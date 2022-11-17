package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tucita.backend.model.Paciente;

@Service
public interface PacienteService {
	public List<Paciente> consultarPacientes();
	public Optional<Paciente> consultarPersonaPorId(Long id);
	public Paciente crearPaciente(Paciente paciente);
	public Paciente actualizarPaciente(Paciente paciente);
	public String eliminarPacientePorId(Long id);
}
