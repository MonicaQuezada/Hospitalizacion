package com.example.demo.Modelo;


import javax.persistence.*;

@Entity
@Table (name="Quirofano")
public class Quirofano {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idQuirofano", nullable = false, columnDefinition = "serial")
	private int idQuirofano;
	
	@Column (name="descripcion", nullable = false)
	private String descripcion;

	public int getIdQuirofano() {
		return idQuirofano;
	}

	public void setIdQuirofano(int idQuirofano) {
		this.idQuirofano = idQuirofano;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
