package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.osdepym.rest.json.BusquedaPersonaResponse;

public class BusquedaPersonaFullResponse {
	
	@JsonProperty
	 private String tipoMensaje;
	@JsonProperty
	 PersonaFisicaRequest personaFisica;
	@JsonProperty
	 Sender sender;
	@JsonProperty
	BusquedaPersonaResponse respuesta;
	 // Getter Methods 

	 public BusquedaPersonaResponse getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(BusquedaPersonaResponse respuesta) {
		this.respuesta = respuesta;
	}

	public String getTipoMensaje() {
	  return tipoMensaje;
	 }

	 public PersonaFisicaRequest getPersonaFisica() {
	  return personaFisica;
	 }

	 public Sender getSender() {
	  return sender;
	 }

	 // Setter Methods 

	 public void setTipoMensaje(String tipoMensaje) {
	  this.tipoMensaje = tipoMensaje;
	 }

	 public void setPersonaFisica(PersonaFisicaRequest personaFisica) {
	  this.personaFisica = personaFisica;
	 }

	 public void setSender(Sender sender) {
	  this.sender = sender;
	 }
}
