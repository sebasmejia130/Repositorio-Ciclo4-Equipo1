package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;


import com.tucita.medicalteam.model.OrdenesRemisiones;

public interface OrdenesRemisionesService {
	
	public OrdenesRemisiones actualizarOrden(OrdenesRemisiones ordenesRemisiones);
	public OrdenesRemisiones crearOrden(OrdenesRemisiones ordenesRemisiones);
	public String eliminarOrden(Long id);
	public Optional<OrdenesRemisiones> consultarOrden(Long id,String tipoExamen);
	public List<OrdenesRemisiones> consultarOrdenPorPaciente(String paciente);
	public List<OrdenesRemisiones> consultarOrdenPorMedico(String medicoGeneral);
	public List<OrdenesRemisiones> consultarLista();

}
