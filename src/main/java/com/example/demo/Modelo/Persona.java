package com.example.demo.Modelo;



import javax.persistence.*;


@MappedSuperclass
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idPersona", nullable = false)
	private int idPersona;
	
	@Column (name="cedula")
	private String cedula;
	
	@Column (name="nombre", nullable = false)
	private String nombre;
	
	@Column (name="apellido", nullable = false)
	private String apellido;
	
	@Column (name="fechaNacimiento", nullable = false)
	private String fechaNacimiento;
	
	@Column (name="edad", nullable = false)
	private int edad;
	@Column (name="sexo", nullable = false)
	private String sexo;
	@Column (name="direccion", nullable = false)
	private String direccion;
	@Column (name="email", nullable = false)
	private String email;
	@Column (name="telefono", nullable = false)
	private int telefono;
	@Column (name="estadoCivil", nullable = false)
	private String estadoCivil;
	
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
