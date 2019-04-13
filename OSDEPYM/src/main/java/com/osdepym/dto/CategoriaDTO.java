package com.osdepym.dto;

import java.util.HashSet;
import java.util.Set;

import com.osdepym.hibernate.entity.MotivoCategoria;

public class CategoriaDTO {
	
	private int idCateg;
	
	private String etiqueta;

	private Set<MotivoCategoria> motivoCategoria = new HashSet<MotivoCategoria>();

	public int getIdCategoria() {
		return idCateg;
	}

	public void setIdCateg(int idCategoria) {
		this.idCateg = idCategoria;
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
