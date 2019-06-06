package com.osdepym.hibernate.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class ObraSocial {
	private Long id;
	private String nombre;
	
	public ObraSocial() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
