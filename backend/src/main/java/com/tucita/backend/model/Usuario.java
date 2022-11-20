package com.tucita.backend.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usurios")
public class Usuario {
	@Id
	private Long id;
	private Long telefono;
	private String correo;
	private String loginName;
	private String contraseña;
	private String rol;

	public Usuario() {
		super();
	}

	public Usuario(Long id, Long telefono, String correo, String loginName, String contraseña, String rol) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.correo = correo;
		this.loginName = loginName;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, correo, id, loginName, rol, telefono);
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
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(correo, other.correo)
				&& Objects.equals(id, other.id) && Objects.equals(loginName, other.loginName)
				&& Objects.equals(rol, other.rol) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", telefono=" + telefono + ", correo=" + correo + ", loginName=" + loginName
				+ ", contraseña=" + contraseña + ", rol=" + rol + "]";
	}
}
