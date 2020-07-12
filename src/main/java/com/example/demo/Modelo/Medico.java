package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="Medico")
public class Medico extends PersonalMedico implements Serializable{
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idMedico", nullable = false)
	private int idMedico;*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name="credencialMedico", nullable = false)
	private int credencialMedico;
	
	@Column(name = "idEspecialidad")
	private int idEspecialidad;
	

	/*public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}*/

	public int getCredencialMedico() {
		return credencialMedico;
	}

	public void setCredencialMedico(int credencialMedico) {
		this.credencialMedico = credencialMedico;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	
	
	

}
