package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
//@Table (name="Medico_Hospitalizacion")
public class Medico_Hospitalizacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cedulaMedico", insertable = true, nullable = false, updatable = false)
	private int cedulaMedico;
	
	@Column(name = "idHospitalizacion", insertable = true, nullable = false, updatable = false)
	private Hospitalizacion idHospitalizacion;
	
	//Paciente
	@Column (name="cedulaPaciente", nullable = false)
	private int cedulaPaciente;
	
	@Column (name="fecha", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fecha;
	
	@Column (name="hora", nullable = false)
	@JsonFormat(pattern="HH:mm", shape=Shape.STRING)
	private String hora;
	
	@Column (name="indicaciones", nullable = false)
	private String indicaciones;

	
	public int getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(int cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public int getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(int cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public Hospitalizacion getIdHospitalizacion() {
		return idHospitalizacion;
	}

	public void setIdHospitalizacion(Hospitalizacion idHospitalizacion) {
		this.idHospitalizacion = idHospitalizacion;
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
