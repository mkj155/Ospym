package com.osdepym.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MensajeDTO {
	@JsonProperty
	private String codigo;
	@JsonProperty
	private String mensaje;
	
	public MensajeDTO() {}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
