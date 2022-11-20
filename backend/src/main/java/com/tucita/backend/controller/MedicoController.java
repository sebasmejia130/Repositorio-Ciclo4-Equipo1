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
import com.tucita.backend.model.Medico;
import com.tucita.backend.service.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
	@Autowired
	private MedicoService servicio;

	@GetMapping
	public ResponseEntity<?> consultarMedicos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarMedicos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
		Optional<Medico> medico = servicio.consultarMedicoPorId(id);
		if (medico.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(medico.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/a/{area}")
	public ResponseEntity<?> consultarPorArea(@PathVariable String area) {
		Optional<Medico> medico = servicio.consultarMedicoPorArea(area);
		if (medico.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(medico.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> crearMedico(@RequestBody Medico medico) {
		Optional<Medico> medicoCrear = servicio.consultarMedicoPorId(medico.getId());
		if (medicoCrear.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(medicoCrear.get());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearMedico(medico));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarMedico(@RequestBody Medico medico, @PathVariable Long id) {
		Optional<Medico> medicoActualizar = servicio.consultarMedicoPorId(id);
		if (medicoActualizar.isPresent()) {
			if (medico.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarMedico(medico));
			} else {
				JSONObject mensajeErrorPorId = new JSONObject();
				mensajeErrorPorId.put("Mensaje", "El id del medico no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("Mensaje", "El medico consultado no tiene registro en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarMedico(@PathVariable Long id){
		Optional<Medico> medicoEliminar = servicio.consultarMedicoPorId(id);
		if (medicoEliminar.isPresent()) {
			servicio.eliminarMedicoPorId(id);
			JSONObject mensajeEliminar = new JSONObject();
			mensajeEliminar.put("Mensaje", "El medico fue eliminado con exito");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		JSONObject mensajeError = new JSONObject();
		mensajeError.put("Mensaje", "Medico no encontrado, no se pudo eliminar");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
