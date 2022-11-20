package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tucita.backend.model.Cita;

@Service
public interface CitaService {
	public List<Cita> consultarCitas();
	public Optional<Cita> consultarCitaPorId(Long id);
	public Optional<Cita> consultarCitaPorMedico(Long medicoId);
	public Cita crearCita(Cita cita);
	public Cita actualizarCita(Cita cita);
	public String eliminarCitaPorId(Long id);
}
