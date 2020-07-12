package com.example.demo.Modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="Area")
public class Area implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column (name="idArea", nullable = false, columnDefinition = "serial")
		private int idArea;
		
		@Column (name="nombre", nullable = false)
		private String nombre;
		
		@Column (name="habitaciones", nullable = false)
		private int habitaciones;
		
		@Column (name="piso", nullable = false)
		private int piso;
		

		public int getIdArea() {
			return idArea;
		}

		public void setIdArea(int idArea) {
			this.idArea = idArea;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getHabitaciones() {
			return habitaciones;
		}

		public void setHabitaciones(int habitaciones) {
			this.habitaciones = habitaciones;
		}

		public int getPiso() {
			return piso;
		}

		public void setPiso(int piso) {
			this.piso = piso;
		}
		

}
