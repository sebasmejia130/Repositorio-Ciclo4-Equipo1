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
	private String genero;
	private Usuario usuario;

	public Medico() {
		super();
	}

	public Medico(Long id, String nombres, String primerApellido, String segundoApellido, String area, String genero,
			Usuario usuario) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.area = area;
		this.genero = genero;
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
		return Objects.hash(area, genero, id, nombres, primerApellido, segundoApellido, usuario);
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
		return Objects.equals(area, other.area) && Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(primerApellido, other.primerApellido)
				&& Objects.equals(segundoApellido, other.segundoApellido) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombres=" + nombres + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", area=" + area + ", genero=" + genero + ", usuario=" + usuario + "]";
	}
}
