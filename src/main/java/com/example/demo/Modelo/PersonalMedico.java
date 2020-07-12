package com.example.demo.Modelo;


import java.util.Date;

import javax.persistence.*;


@MappedSuperclass
public class PersonalMedico extends Persona{
	
	@Column (name="fechaIngreso", nullable = false)
	private Date fechaIngreso;
	
	@Column (name="Contrasenia",nullable=false)
	private String contrasenia;
	
	@Column (name="Rol",nullable=false)
	private String rol;

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	

	
	
	
	
}
