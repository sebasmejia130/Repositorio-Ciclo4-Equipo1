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
import com.tucita.backend.model.Usuario;
import com.tucita.backend.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id){
		Optional<Usuario> usuario = servicio.consultarUsuario(id, null);
		if (usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/u/{rol}")
	public ResponseEntity<?> consultarPorRol(@PathVariable String rol) {
		Optional<Usuario> usuario = servicio.consultarUsuarioPorRol(rol);
		if (usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearUsuario(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> usuarioActualizar = servicio.consultarUsuario(id, null);
		if (usuarioActualizar.isPresent()) {
			if (usuario.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarUsuario(usuario));
			} else {
				JSONObject mensajeErrorPorId = new JSONObject();
				mensajeErrorPorId.put("Mensaje", "El código del usuario no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("Mensaje", "El usuario consultado no tiene registro en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
		Optional<Usuario> usuarioEliminar = servicio.consultarUsuario(id, null);
		if (usuarioEliminar.isPresent()) {
			servicio.eliminarUsuarioPorId(id);
			JSONObject mensajeEliminar = new JSONObject();
			mensajeEliminar.put("Mensaje", "El usuario fue eliminado con exito");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		JSONObject mensajeError = new JSONObject();
		mensajeError.put("Mensaje", "Usuario no encontrado, no se pudo eliminar");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
