package com.example.demo.Modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table (name="Hospitalizacion")
public class Hospitalizacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idIngreso", nullable = false)
	private int idIngreso;
	
	@Column (name="cedulaPaciente", nullable = false)
	private String cedulaPaciente;
	
	@Column (name="idCaso", nullable = false)
	private int idCaso;
	
	@Column (name="fechaIngreso", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fechaIngreso;
	
	@Column (name="horaIngreso", nullable = false)
	@JsonFormat(pattern="HH:mm", shape=Shape.STRING)
	private String horaIngreso;
	
	@Column(name = "idCama", nullable = false, updatable = false)
	private int cama;
	
	@Column (name="fechaSalida")
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private String fechaSalida;
	
	@Column (name="horaSalida")
	@JsonFormat(pattern="HH:mm", shape=Shape.STRING)
	private String horaSalida;
	
	//Servicios
	 @JoinTable(
		        name = "Servicios_Hospitalizacion",
		        joinColumns = @JoinColumn(name = "idHospitalizacion", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="idServicio", nullable = false)
		    )
		    @ManyToMany(cascade = CascadeType.ALL)
		    private List<Servicio> servicios;

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public int getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(int idCaso) {
		this.idCaso = idCaso;
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

	

	public int getCama() {
		return cama;
	}

	public void setCama(int cama) {
		this.cama = cama;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
}
