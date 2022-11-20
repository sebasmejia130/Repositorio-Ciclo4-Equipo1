package com.tucita.backend.controller;

import java.util.Optional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tucita.backend.model.Paciente;
import com.tucita.backend.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarPacientes(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarPacientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPacientePorId(@PathVariable Long id){
		Optional<Paciente> paciente = servicio.consultarPacientePorId(id);
		if (paciente.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente){
		Optional<Paciente> pacienteCrear = servicio.consultarPacientePorId(paciente.getCodigoPaciente());
		if (pacienteCrear.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearPaciente(paciente));
	}
	
	@PutMapping("/{codigoPaciente}")
	public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente, @PathVariable Long codigoPaciente){
		Optional<Paciente> pacienteActualizar = servicio.consultarPacientePorId(codigoPaciente);
		if (pacienteActualizar.isPresent()) {
			if (paciente.getCodigoPaciente().equals(codigoPaciente)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarPaciente(paciente));
			} else {
				JSONObject mensajeErrorPorId = new JSONObject();
				mensajeErrorPorId.put("Mensaje", "El código del paciente no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("Mensaje", "El paciente consultado no tiene registro en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return null;
	}
	
	@DeleteMapping("/{codigoPaciente}")
	public ResponseEntity<?> eliminarPaciente(@PathVariable Long codigoPaciente){
		Optional<Paciente> pacienteEliminar = servicio.consultarPacientePorId(codigoPaciente);
		if (pacienteEliminar.isPresent()) {
			servicio.eliminarPacientePorId(codigoPaciente);
			JSONObject mensajeEliminar = new JSONObject();
			mensajeEliminar.put("Mensaje", "El paciente fue eliminado con exito");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		JSONObject mensajeError = new JSONObject();
		mensajeError.put("Mensaje", "Medico no encontrado, no se pudo eliminar");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
