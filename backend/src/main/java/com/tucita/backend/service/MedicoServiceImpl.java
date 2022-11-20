package com.tucita.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.backend.model.Medico;
import com.tucita.backend.repository.MedicoRepository;
@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repositorio;

	@Override
	public List<Medico> consultarMedicos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Medico> consultarMedicoPorId(Long id) {
		if (id == null) {
			return Optional.empty();
		}
			return repositorio.findById(id);
	}

	@Override
	public Optional<Medico> consultarMedicoPorArea(String area) {
		if (area == null) {
			return Optional.empty();
		} else {
			return repositorio.findByArea(area);
		}
	}

	@Override
	public Medico crearMedico(Medico medico) {
		Optional<Medico> consultarParaCrear = repositorio.findById(medico.getId());
		if (consultarParaCrear.isPresent()) {
			return null;
		}
		List<Medico> medicos = repositorio.findByNombres(medico.getNombres());
		if (medicos.size() > 0) {
			return medicos.get(0);
		}
		return repositorio.insert(medico);
	}

	@Override
	public Medico actualizarMedico(Medico medico) {
		Optional<Medico> consultarParaActualizar = repositorio.findById(medico.getId());
		if (consultarParaActualizar.isPresent()) {
			return repositorio.save(medico);
		} else {
			return null;
		}
	}

	@Override
	public String eliminarMedicoPorId(Long id) {
		Optional<Medico> consultarParaEliminar = repositorio.findById(id);
		if (consultarParaEliminar.isPresent()) {
			repositorio.delete(consultarParaEliminar.get());
			return "Registro eliminado correctamente";
		} else {
			return "Registro no encontrado, no se puede eliminar";
		}
	}
}
