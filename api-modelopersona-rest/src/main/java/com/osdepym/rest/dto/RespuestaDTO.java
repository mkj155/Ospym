package com.osdepym.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaDTO {
	@JsonProperty
	private List<PersonaDTO> personas;
	@JsonProperty
	private String encontrada;
	@JsonProperty
	private MensajeDTO mensaje;
	@JsonProperty
	private int cantidad;
	
	public RespuestaDTO() {}
	
	public List<PersonaDTO> getPersonas() {
		return personas;
	}

	public void setPersonas(List<PersonaDTO> personas) {
		this.personas = personas;
	}

	public String getEncontrada() {
		return encontrada;
	}

	public void setEncontrada(String encontrada) {
		this.encontrada = encontrada;
	}

	public MensajeDTO getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeDTO mensaje) {
		this.mensaje = mensaje;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}