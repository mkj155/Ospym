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
@Table(name="ESPECIALIDADES", schema = "tramites_online")
public class Especialidad {
	
	private int idEspecialidad;
	private String etiqueta;
	private Set<EspecialidadPrestacion> especialidadPrestaciones;
	
	public Especialidad() {}
	
	public Especialidad(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public Especialidad(String etiqueta, Set<EspecialidadPrestacion> especialidadPrestaciones) {
		this.etiqueta = etiqueta;
		this.especialidadPrestaciones = especialidadPrestaciones;
	}
    
	@Id
	@Column(name="ID_ESPECIALIDAD")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@OneToMany(mappedBy = "especialidad")
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
