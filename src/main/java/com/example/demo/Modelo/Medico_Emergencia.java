package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
//@Table (name="Medico_Emergencia")
public class Medico_Emergencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idEmergencia", insertable = true, nullable = false, updatable = false)
	private int idEmergencia;

	@Column(name = "cedulaMedico", insertable = true, nullable = false, updatable = false)
	private String cedulaMedico;
	
	@Column (name="cedulaPaciente", nullable = false)
	private String cedulaPaciente;
	
	@Column (name="fecha", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fecha;
	
	@Column (name="hora", nullable = false)
	@JsonFormat(pattern="HH:mm", shape=Shape.STRING)
	private String hora;
	
	@Column (name="indicaciones", nullable = false)
	private String indicaciones;

	

	public int getIdEmergencia() {
		return idEmergencia;
	}

	public void setIdEmergencia(int idEmergencia) {
		this.idEmergencia = idEmergencia;
	}


	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
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

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	

}
