package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Codebeautify {
	@JsonProperty
	 private String tipoMensaje;
	@JsonProperty
	 PersonaFisica personaFisica;
	@JsonProperty
	 Sender sender;


	 // Getter Methods 

	 public String getTipoMensaje() {
	  return tipoMensaje;
	 }

	 public PersonaFisica getPersonaFisica() {
	  return personaFisica;
	 }

	 public Sender getSender() {
	  return sender;
	 }

	 // Setter Methods 

	 public void setTipoMensaje(String tipoMensaje) {
	  this.tipoMensaje = tipoMensaje;
	 }

	 public void setPersonaFisica(PersonaFisica personaFisica) {
	  this.personaFisica = personaFisica;
	 }

	 public void setSender(Sender sender) {
	  this.sender = sender;
	 }
	}