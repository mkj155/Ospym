package com.osdepym.dto;

public class EstadoDTO {
	private Long estadoRegistroID;
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
