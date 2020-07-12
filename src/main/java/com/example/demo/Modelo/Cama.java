package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="Cama")
public class Cama implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idCama", nullable = false, columnDefinition = "serial")
	private int idCama;
	
	@Column(name = "idArea", nullable = false, updatable = false)
	private int idArea;	
		
	@Column(name = "idhabitacion", nullable = false, updatable = false)
	private int idHabitacion;
	
	@Column (name="estado", nullable = false)
	private String estado;
	
	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	

	

}
