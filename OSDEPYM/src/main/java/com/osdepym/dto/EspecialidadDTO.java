package com.osdepym.dto;

import java.util.Set;

import com.osdepym.hibernate.entity.EspecialidadPrestacion;

public class EspecialidadDTO {

	private int idEspecialidad;
	
	private String etiqueta;
	
	private Set<EspecialidadPrestacion> especialidadPrestacions;

	public EspecialidadDTO(int idEspecialidad, String etiqueta) {
		this.idEspecialidad = idEspecialidad;
		this.etiqueta = etiqueta;
	}
	
	public EspecialidadDTO() {}
	
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

	public Set<EspecialidadPrestacion> getEspecialidadPrestacions() {
		return especialidadPrestacions;
	}

	public void setEspecialidadPrestacions(Set<EspecialidadPrestacion> especialidadPrestacions) {
		this.especialidadPrestacions = especialidadPrestacions;
	}
	
}
