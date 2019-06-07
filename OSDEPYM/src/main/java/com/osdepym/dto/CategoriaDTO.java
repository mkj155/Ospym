package com.osdepym.dto;

import java.util.HashSet;
import java.util.Set;

import com.osdepym.hibernate.entity.MotivoCategoria;

public class CategoriaDTO {
	
	private Long idCategoria;
	
	private String etiqueta;

	private Set<MotivoCategoria> motivoCategoria = new HashSet<MotivoCategoria>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Set<MotivoCategoria> getMotivoCategoria() {
		return motivoCategoria;
	}

	public void setMotivoCategoria(Set<MotivoCategoria> motivoCategoria) {
		this.motivoCategoria = motivoCategoria;
	}

}
