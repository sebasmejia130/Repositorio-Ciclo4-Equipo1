package com.tucita.backend.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("citas")
public class Cita {
	private Long id;
	private String fecha;
	private String hora;
	private String area;
	private Medico medico;

	public Cita(Long id, String fecha, String hora, String area, Medico medico) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.area = area;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, fecha, hora, id, medico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(area, other.area) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(id, other.id)
				&& Objects.equals(medico, other.medico);
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", area=" + area + ", medico=" + medico + "]";
	}
}
