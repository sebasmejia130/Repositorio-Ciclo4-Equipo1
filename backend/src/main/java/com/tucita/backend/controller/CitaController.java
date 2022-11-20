package com.tucita.backend.controller;

import java.util.List;
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
import com.tucita.backend.model.Cita;
import com.tucita.backend.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
	@Autowired
	private CitaService servicio;

	@GetMapping
	public ResponseEntity<?> consultarCitas() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.consultarCitas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
		Optional<Cita> respuesta = servicio.consultarCitaPorId(id);
		if (respuesta.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCitaPorId(id));
		}
		JSONObject mensajeError = new JSONObject();
		mensajeError.put("mensaje", "Id no encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
	}
	
	@GetMapping("/m/{medicoId}")
	public ResponseEntity<?> consultarPorMedico(@PathVariable Long medicoId){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCitaPorMedico(medicoId));
	}

	@PostMapping
	public ResponseEntity<?> crearCita(@RequestBody Cita cita) {
		List<Cita> citaCrear = servicio.consultarCitas();
		for (Cita citaTemp : citaCrear) {
			if (citaTemp.getFecha() == cita.getFecha() && citaTemp.getHora() == cita.getHora()
					&& citaTemp.getMedicoId().equals(cita.getMedicoId())) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearCita(cita));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarCita(@RequestBody Cita cita, @PathVariable Long id){
		Optional<Cita> citaActualizar = servicio.consultarCitaPorId(id);
		if (citaActualizar.isPresent()) {
			if (cita.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarCita(cita));
			} else {
				JSONObject mensajeErrorPorId = new JSONObject();
				mensajeErrorPorId.put("Mensaje", "El id de la cita no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("Mensaje", "La cita consultada no tiene registro en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCita(@PathVariable Long id){
		Optional<Cita> citaEliminar = servicio.consultarCitaPorId(id);
		if (citaEliminar.isPresent()) {
			servicio.eliminarCitaPorId(id);
			JSONObject mensajeEliminar = new JSONObject();
			mensajeEliminar.put("Mensaje", "La cita fue eliminado con exito");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		JSONObject mensajeError = new JSONObject();
		mensajeError.put("Mensaje", "Cita no encontrado, no se pudo eliminar");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
