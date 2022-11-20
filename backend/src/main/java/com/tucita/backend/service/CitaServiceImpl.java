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
	public Optional<Cita> consultarCitaPorMedico(Long medicoId) {
		if (medicoId == null) {
			return Optional.empty();
		}
		return repositorio.findByMedico(medicoId);
	}

	@Override
	public Cita crearCita(Cita cita) {
		List<Cita> consultarParaCrear = repositorio.findAll();
		for (Cita citaTemporal : consultarParaCrear) {
			if (citaTemporal.getFecha() == cita.getFecha() && citaTemporal.getHora() == cita.getHora()
					&& citaTemporal.getMedicoId().equals(cita.getMedicoId())) {
				return null;
			}
			List<Cita> medicos = repositorio.findByArea(cita.getArea());
			if (medicos.size() > 0) {
				return medicos.get(0);
			}
		}
		return repositorio.insert(cita);
	}

	@Override
	public Cita actualizarCita(Cita cita) {
		Optional<Cita> consultarParaActualizar = repositorio.findById(cita.getId());
		if (consultarParaActualizar.isPresent()) {
			return repositorio.save(cita);
		}
		return null;
	}

	@Override
	public String eliminarCitaPorId(Long id) {
		Optional<Cita> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "Registro eliminado correctamente";
		}
		return "Registro no encontrado, no se puede eliminar";
	}
}
