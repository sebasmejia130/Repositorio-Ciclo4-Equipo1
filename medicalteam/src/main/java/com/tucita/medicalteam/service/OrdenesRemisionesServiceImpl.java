package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.OrdenesRemisiones;
import com.tucita.medicalteam.repository.OrdenesRemisionesRepository;


@Service
public class OrdenesRemisionesServiceImpl implements OrdenesRemisionesService  {
	
	@Autowired
	private OrdenesRemisionesRepository repositorio;
	
	@Override
	public OrdenesRemisiones actualizarOrden(OrdenesRemisiones ordenesRemisiones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenesRemisiones crearOrden(OrdenesRemisiones ordenesRemisiones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarOrden(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<OrdenesRemisiones> consultarOrden(Long id, String tipoExamen) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<OrdenesRemisiones> consultarOrdenPorPaciente(String paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenesRemisiones> consultarOrdenPorMedico(String medicoGeneral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenesRemisiones> consultarLista() {
		// TODO Auto-generated method stub
		return null;
	}

}
