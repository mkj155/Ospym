package com.osdepym.dto;

import java.util.Set;

import com.osdepym.hibernate.entity.MotivoCategoria;

public class MotivosDTO {

	private int idMotivo;
	
	private String etiqueta;
	
	private Set<MotivoCategoria> motivoCategorias;

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
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
