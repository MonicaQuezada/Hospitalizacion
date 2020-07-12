package com.example.demo.Modelo;


import javax.persistence.*;

@Entity
@Table (name="Interno")
public class Interno extends PersonalMedico{
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idInterno", nullable = false)
	private int idInterno;*/
	
	
	@Column (name="universidad", nullable = false)
	private String universidad;


	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
	

}
