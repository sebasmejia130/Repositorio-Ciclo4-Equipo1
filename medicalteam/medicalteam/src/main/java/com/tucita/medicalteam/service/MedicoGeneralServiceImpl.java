package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.MedicoGeneral;
import com.tucita.medicalteam.repository.MedicoGeneralRepository;

@Service
public class MedicoGeneralServiceImpl implements MedicoGeneralService{
	
	
	private MedicoGeneralRepository repositorio;
	
	@Override
	public MedicoGeneral actualizarMedicoGeneral(MedicoGeneral medicoGeneral) {
		Optional<MedicoGeneral> medicoAActualizar = repositorio.findById(medicoGeneral.getId());
		if(medicoAActualizar.isPresent()) {
			return repositorio.save(medicoGeneral);
		}
		return null;
	}

	@Override
	public MedicoGeneral crearMedico(MedicoGeneral medicoGeneral) {
		Optional<MedicoGeneral> medicoACrear = repositorio.findById(medicoGeneral.getId());
		if(medicoACrear.isPresent()) {
			return null;
		}
		List<MedicoGeneral> medicos = repositorio.findByNombre(medicoGeneral.getNombreMedico());
		if(medicos.size() > 0) {
			return medicos.get(0);
		}
		return repositorio.insert(medicoGeneral);
	}

	@Override
	public String eliminarMedicoGeneral(Long id) {
		Optional<MedicoGeneral> medicoAEliminar = repositorio.findById(id);
		if(medicoAEliminar.isPresent()) {
			repositorio.delete(medicoAEliminar.get());
			return "El medico fue eliminardo con exito!";
		}
		return "No se puede eliminar el medico, ID no encontrada";
	}

	@Override
	public Optional<MedicoGeneral> consultarMedicoGeneral(Long id, String nombreMedico) {
		if (id == null && nombreMedico == null) {
			return Optional.empty();
		}
		if (id == null) {
			List<MedicoGeneral> lista = repositorio.findByNombre(nombreMedico);
			return Optional.of(lista.get(0));
		}
		return repositorio.findById(id);
	}

	@Override
	public List<MedicoGeneral> consultarLista() {
		return repositorio.findAll();
	}

}
