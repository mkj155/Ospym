package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentoIdentidad {

	@JsonProperty
	private String tipo = "";
	@JsonProperty
	private Long numero;
	
	
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
