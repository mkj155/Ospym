package com.osdepym.rest.entity;

import java.util.Date;

public class ModeloPersona {
	private String apellido; 
	private String nombre; 
	private String sexo;
	private Date fechaNacimiento;
	private Long personaID;
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Long getPersonaID() {
		return personaID;
	}
	public void setPersonaID(Long personaID) {
		this.personaID = personaID;
	}
}
