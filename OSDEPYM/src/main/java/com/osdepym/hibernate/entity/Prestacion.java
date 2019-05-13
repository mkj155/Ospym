package com.osdepym.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRESTACIONES", schema = "tramites_online")
public class Prestacion {
	
	private int idPrestacion;
	private String etiqueta;
	private Set<EspecialidadPrestacion> especialidadPrestaciones;
    
	public Prestacion() {}
	
	public Prestacion(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public Prestacion(String etiqueta, Set<EspecialidadPrestacion> especialidadPrestaciones) {
		this.etiqueta = etiqueta;
		this.especialidadPrestaciones = especialidadPrestaciones;
	}
	
	
	@Id
	@Column(name="ID_PRESTACION")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPrestacion() {
		return idPrestacion;
	}

	public void setIdPrestacion(int idPrestacion) {
		this.idPrestacion = idPrestacion;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@OneToMany(mappedBy = "prestacion")
	public Set<EspecialidadPrestacion> getEspecialidadPrestaciones() {
		return especialidadPrestaciones;
	}

	public void setEspecialidadPrestaciones(Set<EspecialidadPrestacion> especialidadPrestaciones) {
		this.especialidadPrestaciones = especialidadPrestaciones;
	}
	
	public void addEspecialidadPrestaciones(EspecialidadPrestacion especialidadPrestaciones) {
		this.especialidadPrestaciones.add(especialidadPrestaciones);
	}
	
}
