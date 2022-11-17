package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.tucita.backend.model.Remision;

@Service
public interface RemisionService {
	public List<Remision> consultarCitas();
	public Optional<Remision> consultarCitaPorId(Long id);
	public Remision crearCita(Remision cita);
	public Remision actualizarCita(Remision cita);
	public String eliminarCitaPorId(Long id);
}
