package com.tucita.backend.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pacientes")
public class Paciente {
	@Id
	private Long codigoPaciente;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private Long edad;
	private String direccion;
	private String genero;
	private Usuario usuario;

	public Paciente() {
		super();
	}

	public Paciente(Long codigoPaciente, String nombres, String primerApellido, String segundoApellido, Long edad,
			String direccion, String genero, Usuario usuario) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.edad = edad;
		this.direccion = direccion;
		this.genero = genero;
		this.usuario = usuario;
	}

	public Long getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Long codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
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

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoPaciente, direccion, edad, genero, nombres, primerApellido, segundoApellido, usuario);
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
		return Objects.equals(codigoPaciente, other.codigoPaciente) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(edad, other.edad) && Objects.equals(genero, other.genero)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(primerApellido, other.primerApellido)
				&& Objects.equals(segundoApellido, other.segundoApellido) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Paciente [codigoPaciente=" + codigoPaciente + ", nombres=" + nombres + ", primerApellido="
				+ primerApellido + ", segundoApellido=" + segundoApellido + ", edad=" + edad + ", direccion="
				+ direccion + ", genero=" + genero + ", usuario=" + usuario + "]";
	}
}
