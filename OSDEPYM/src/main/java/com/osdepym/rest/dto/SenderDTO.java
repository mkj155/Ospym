package com.osdepym.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenderDTO {
	@JsonProperty
	private String nombre;
	@JsonProperty
	private String fechaHora;
	@JsonProperty
	private String uid;
	
	public SenderDTO() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	} 
}
