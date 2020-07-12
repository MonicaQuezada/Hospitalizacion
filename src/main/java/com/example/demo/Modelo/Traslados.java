package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table (name="Traslados")
public class Traslados implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idHospitalizacion",  insertable = true,nullable = false, updatable = false)
	private int idHospitalizacion;
	
	@Column(name = "idCama", nullable = false,  insertable = true,updatable = false)
	private int idCama;
	
	@Column (name="cedulaPaciente", nullable = false)
	private String cedulaPaciente;
	
	@Column (name="fechaIngreso", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fechaIngreso;
	
	@Column (name="fechaSalida")
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fechaSalida;


	public int getIdHospitalizacion() {
		return idHospitalizacion;
	}

	public void setIdHospitalizacion(int idHospitalizacion) {
		this.idHospitalizacion = idHospitalizacion;
	}

	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
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

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
}
