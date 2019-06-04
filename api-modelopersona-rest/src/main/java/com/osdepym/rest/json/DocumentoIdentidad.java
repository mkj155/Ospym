package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentoIdentidad {

	@JsonProperty
	private String tipo;
	@JsonProperty
	private Integer numero;
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
	
}
