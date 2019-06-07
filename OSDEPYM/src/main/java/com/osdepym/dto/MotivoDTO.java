package com.osdepym.dto;

import java.util.Set;

import com.osdepym.hibernate.entity.MotivoCategoria;

public class MotivoDTO {

	private Long idMotivo;
	
	private String etiqueta;
	
	private Set<MotivoCategoria> motivoCategorias;

	public Long getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Set<MotivoCategoria> getMotivoCategorias() {
		return motivoCategorias;
	}

	public void setMotivoCategorias(Set<MotivoCategoria> motivoCategorias) {
		this.motivoCategorias = motivoCategorias;
	}
	
}
