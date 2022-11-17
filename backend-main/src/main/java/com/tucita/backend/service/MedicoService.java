package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tucita.backend.model.Medico;

@Service
public interface MedicoService {
	public List<Medico> consultarMedicos();
	public Optional<Medico> consultarMedicoPorId(Long id);
	public Medico crearMedico(Medico medico);
	public Medico actualizarMedico(Medico medico);
	public String eliminarMedicoPorId(Long id);
}
