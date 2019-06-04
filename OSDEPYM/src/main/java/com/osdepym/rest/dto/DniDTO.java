package com.osdepym.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DniDTO {
	@JsonProperty
	private String tipo;
	@JsonProperty
	private Long numero;
	
	public DniDTO() {}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
}
