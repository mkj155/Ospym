package com.osdepym.rest.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.osdepym.rest.dto.PersonaSearchDTO;
import com.osdepym.rest.dto.RespuestaDTO;
import com.osdepym.rest.dto.SenderDTO;

public class BusquedaPersonaResponse {
	@JsonCreator
	public BusquedaPersonaResponse() {}
	
	@JsonProperty
	private String tipoMensaje;
	@JsonProperty
	private PersonaSearchDTO personaFisica;
	@JsonProperty
	private SenderDTO sender;
	@JsonProperty
	private RespuestaDTO respuesta;
	
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public PersonaSearchDTO getPersonaFisica() {
		return personaFisica;
	}
	public void setPersonaFisica(PersonaSearchDTO personaFisica) {
		this.personaFisica = personaFisica;
	}
	public SenderDTO getSender() {
		return sender;
	}
	public void setSender(SenderDTO sender) {
		this.sender = sender;
	}
	public RespuestaDTO getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaDTO respuesta) {
		this.respuesta = respuesta;
	}	
}