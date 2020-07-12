package com.example.demo.Modelo;

import javax.persistence.*;

@Entity
@Table (name="Especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idEspecialidad", nullable = false)
	private int idEspecialidad;
	
	@Column (name="nombre", nullable = false)
	private String nombre;
	
	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
