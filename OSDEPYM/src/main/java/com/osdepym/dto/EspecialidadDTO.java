package com.osdepym.dto;

import java.util.Set;

import com.osdepym.hibernate.entity.EspecialidadPrestacion;

public class EspecialidadDTO {

	private Long idEspecialidad;
	
	private String etiqueta;
	
	private Set<EspecialidadPrestacion> especialidadPrestacions;

	public EspecialidadDTO(Long idEspecialidad, String etiqueta) {
		this.idEspecialidad = idEspecialidad;
		this.etiqueta = etiqueta;
	}
	
	public EspecialidadDTO() {}
	
	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
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
