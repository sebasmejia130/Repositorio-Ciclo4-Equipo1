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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicoGeneral crearMedico(MedicoGeneral medicoGeneral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarMedicoGeneral(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MedicoGeneral> consultarMedicoGeneral(Long id, String nombreMedico) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<MedicoGeneral> consultarMedicoPorApellidoPaterno(String apellidoPaternoMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicoGeneral> consultarMedicoPorApellidoMaterno(String apellidoMaternoMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicoGeneral> consultarLista() {
		// TODO Auto-generated method stub
		return null;
	}

}
