package com.example.demo.Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;



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
	private Date fechaIngreso;
	
	@Column (name="horaIngreso", nullable = false)
	private String horaIngreso;
	
	@Column(name = "idCama", nullable = false, updatable = false)
	private int cama;
	
	@Column (name="fechaSalida")
	private Date fechaSalida;
	
	@Column (name="horaSalida")
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
	

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
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
