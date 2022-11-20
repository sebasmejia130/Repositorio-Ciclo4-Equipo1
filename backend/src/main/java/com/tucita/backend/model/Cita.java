package com.tucita.backend.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("citas")
public class Cita {
	@Id
	private Long id;
	private String fecha;
	private String hora;
	private String area;
	private Long medicoId;
	private Long pacienteId;

	public Cita() {
		super();
	}

	public Cita(Long id, String fecha, String hora, String area, Long medico, Long paciente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.area = area;
		this.medicoId = medico;
		this.pacienteId = paciente;
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

	public Long getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, fecha, hora, id, medicoId, pacienteId);
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
				&& Objects.equals(medicoId, other.medicoId) && Objects.equals(pacienteId, other.pacienteId);
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", area=" + area + ", medicoId=" + medicoId
				+ ", pacienteId=" + pacienteId + "]";
	}
}
