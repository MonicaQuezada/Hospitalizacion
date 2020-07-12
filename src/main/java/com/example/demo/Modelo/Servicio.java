package com.example.demo.Modelo;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="Servicio")
public class Servicio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name="idCaso", nullable = false)
	private int idCaso;
	
	//Paciente
	@Column (name="idPaciente", nullable = false)
	private int idPaciente;
	
	@Column (name="descripcion", nullable = false)
	private String descripcion;
	
	@Column (name="valor", nullable = false)
	private double valor;
	
	@Column (name="cantidad", nullable = false)
	private int cantidad;

	@Column (name="modulo", nullable = false)
	private String modulo;
	
	@Column (name="tabla", nullable = false)
	private String tabla;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idServicio", nullable = false, columnDefinition = "serial")
	private int idServicio;
	
	//Hospitalizacion
    @ManyToMany(mappedBy = "servicios")
    private List<Hospitalizacion> hospitalizacion;

	public int getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(int idCaso) {
		this.idCaso = idCaso;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public List<Hospitalizacion> getHospitalizacion() {
		return hospitalizacion;
	}

	public void setHospitalizacion(List<Hospitalizacion> hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}
    
    
}
