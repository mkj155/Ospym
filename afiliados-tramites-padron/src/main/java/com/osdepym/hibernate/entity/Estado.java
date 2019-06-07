package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Estado {
	@Id
	@Column(name = "EstadoRegistro_ID", updatable = false, nullable = false)
	private Long estadoRegistroID;
	
	@Column(name = "DescripcionEstado", updatable = false)
	private String descripcionEstado;

	public Long getEstadoRegistroID() {
		return estadoRegistroID;
	}

	public void setEstadoRegistroID(Long estadoRegistroID) {
		this.estadoRegistroID = estadoRegistroID;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
}
