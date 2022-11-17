package com.tucita.backend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("medicos")
public class Medico {
	@Id
	private Long id;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private String area;
	private Byte genero;
	private Long telefono;
	private String correo;
	private Usuario usuario;

	public Medico(Long id, String nombres, String primerApellido, String segundoApellido, String area, Byte genero,
			Long telefono, String correo, Usuario usuario) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.area = area;
		this.genero = genero;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Byte getGenero() {
		return genero;
	}

	public void setGenero(Byte genero) {
		this.genero = genero;
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
		return Objects.hash(area, correo, genero, id, nombres, primerApellido, segundoApellido, telefono, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(area, other.area) && Objects.equals(correo, other.correo)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(primerApellido, other.primerApellido)
				&& Objects.equals(segundoApellido, other.segundoApellido) && Objects.equals(telefono, other.telefono)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombres=" + nombres + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", area=" + area + ", genero=" + genero + ", telefono=" + telefono + ", correo="
				+ correo + ", usuario=" + usuario + "]";
	}
}
