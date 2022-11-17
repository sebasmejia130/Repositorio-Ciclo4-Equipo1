package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.Paciente;
import com.tucita.medicalteam.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repositorio;
	
	@Override
	public Paciente actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente crearPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarPaciente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Paciente> consultarPaciente(Long id, String nombrePaciente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Paciente> consultarPacientePorTelefono(Long telefonoPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> consultarLista() {
		// TODO Auto-generated method stub
		return null;
	}

}
