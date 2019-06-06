package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusquedaPersonaRequest {
	@JsonProperty
	 private String tipoMensaje;
	@JsonProperty
	 PersonaFisicaRequest personaFisicaRequest;
	@JsonProperty
	 Sender sender;


	public String getTipoMensaje() {
	  return tipoMensaje;
	 }

	 public PersonaFisicaRequest getPersonaFisica() {
	  return personaFisicaRequest;
	 }

	 public Sender getSender() {
	  return sender;
	 }

	 // Setter Methods 

	 public void setTipoMensaje(String tipoMensaje) {
	  this.tipoMensaje = tipoMensaje;
	 }

	 public void setPersonaFisica(PersonaFisicaRequest personaFisicaRequest) {
	  this.personaFisicaRequest = personaFisicaRequest;
	 }

	 public void setSender(Sender sender) {
	  this.sender = sender;
	 }
	}