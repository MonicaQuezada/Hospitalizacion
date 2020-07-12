package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table (name="Emergencia")
public class Emergencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idEmergencia", nullable = false, columnDefinition = "serial")
	private int idEmergencia;
	
	@Column (name="cedulaPaciente", nullable = false)
	private String cedulaPaciente;
	
	@Column (name="fechaIngreso", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fechaIngreso;
	
	@Column (name="horaIngreso",  nullable = false)
	@JsonFormat(pattern="HH:mm", shape=Shape.STRING)
	private String horaIngreso;
	
	@Column (name="causa", nullable = false)
	private String causa;
	
	@Column (name="prioridad", nullable = false)
	private String prioridad;

	public int getIdEmergencia() {
		return idEmergencia;
	}

	public void setIdEmergencia(int idEmergencia) {
		this.idEmergencia = idEmergencia;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	

	
}
