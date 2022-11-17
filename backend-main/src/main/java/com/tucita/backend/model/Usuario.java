package com.tucita.backend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usurios")
public class Usuario {
	@Id
	private Long id;
	private String usuario;
	private String contraseña;
	private String tipo;

	public Usuario(Long id, String usuario, String contraseña, String tipo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, id, tipo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(id, other.id)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", contraseña=" + contraseña + ", tipo=" + tipo + "]";
	}
}
