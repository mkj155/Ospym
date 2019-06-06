package com.osdepym.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SolicitudesForm {
	private Long cuil;
	private Long numeroRegistro;
	private String obraSocial;
	private String apellido;
	private String nombre;
	private String estado;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date fechaCarga;
	private Long numeroSolicitud;
	private Long dni;
	private Long cuit;
	
	public SolicitudesForm() {}
	
	public Long getCuil() {
		return cuil;
	}
	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}
	public Long getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public Long getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(Long numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

}