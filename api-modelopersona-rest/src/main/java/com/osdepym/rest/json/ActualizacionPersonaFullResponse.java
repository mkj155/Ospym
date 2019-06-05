package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizacionPersonaFullResponse {
	@JsonProperty
	 private String tipoMensaje;
	@JsonProperty
	 PersonaFisicaRequest personaFisica;
	@JsonProperty
	 Sender sender;
	@JsonProperty
	ActualizacionPersonaResponse respuesta;
	 // Getter Methods 

	 public ActualizacionPersonaResponse getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ActualizacionPersonaResponse respuesta) {
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
