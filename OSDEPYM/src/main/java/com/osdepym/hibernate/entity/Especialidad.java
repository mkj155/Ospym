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
@Table(name="Especialidades", schema = "tramites_online")
public class Especialidad {
	
	public Especialidad() {}
	
	public Especialidad(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public Especialidad(String etiqueta, Set<EspecialidadPrestacion> especialidadPrestaciones) {
		this.etiqueta = etiqueta;
		this.especialidadPrestaciones = especialidadPrestaciones;
	}
	
	private int idEspecialidad;
	private String etiqueta;
	private Set<EspecialidadPrestacion> especialidadPrestaciones;
    
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

	@OneToMany(mappedBy = "Especialidad")
	public Set<EspecialidadPrestacion> getEspecialidadPrestaciones() {
		return especialidadPrestaciones;
	}

	public void setEspecialidadPrestacion(Set<EspecialidadPrestacion> especialidadPrestaciones) {
		this.especialidadPrestaciones = especialidadPrestaciones;
	}
	
	public void addEspecialidadPrestacion(EspecialidadPrestacion especialidadPrestaciones) {
		this.especialidadPrestaciones.add(especialidadPrestaciones);
	}
	
}
