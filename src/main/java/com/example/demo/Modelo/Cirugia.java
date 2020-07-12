package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="Cirugia")
public class Cirugia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idCirugia", nullable = false)
	private int idCirugia;
	
	@Column (name="idCaso", nullable = false)
	private int idCaso;
	
	@Column (name="cedulaPaciente", nullable=false)
	private String cedulaPaciente;
	
	@Column(name = "cedulaMedico", nullable = false, updatable = false)
	private String cedulaMedico;
	
	@Column (name="tipoCirugia", nullable = false)
	private String tipoCirugia;
	
	@Column (name="costo", nullable = false)
	private int costo;

	@Column (name="descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "idQuirofano", nullable = false, updatable = false)
	private int idQuirofano;
	

	public int getIdCirugia() {
		return idCirugia;
	}

	public void setIdCirugia(int idCirugia) {
		this.idCirugia = idCirugia;
	}

	public int getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(int idCaso) {
		this.idCaso = idCaso;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public String getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(String tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdQuirofano() {
		return idQuirofano;
	}

	public void setIdQuirofano(int idQuirofano) {
		this.idQuirofano = idQuirofano;
	}

	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	
	
	
	
	
	

}
