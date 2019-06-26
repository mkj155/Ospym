package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "CargaMasivaErrorValidacion", schema = "ga")
public class ErrorValidacion {

	@Id
	@Column(name = "ErrorValidacion_ID", updatable = false, nullable = false)
	private Long idValidacion;
	
	@Column(name = "DescripcionError", updatable = false)
	private String descripcion;

	public Long getIdValidacion() {
		return idValidacion;
	}

	public void setIdValidacion(Long idValidacion) {
		this.idValidacion = idValidacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
