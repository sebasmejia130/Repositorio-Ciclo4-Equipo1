package com.tucita.backend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pacientes")
public class Paciente {
	@Id
	private Long id;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private Byte genero;
	private Long edad;
	private Long telefono;
	private String correo;
	private Usuario usuario;

	public Paciente(Long id, String nombres, String primerApellido, String segundoApellido, Byte genero, Long edad,
			Long telefono, String correo, Usuario usuario) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.genero = genero;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Byte getGenero() {
		return genero;
	}

	public void setGenero(Byte genero) {
		this.genero = genero;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correo, edad, genero, id, nombres, primerApellido, segundoApellido, telefono, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(correo, other.correo) && Objects.equals(edad, other.edad)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(primerApellido, other.primerApellido)
				&& Objects.equals(segundoApellido, other.segundoApellido) && Objects.equals(telefono, other.telefono)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombres=" + nombres + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", genero=" + genero + ", edad=" + edad + ", telefono="
				+ telefono + ", correo=" + correo + ", usuario=" + usuario + "]";
	}
}
