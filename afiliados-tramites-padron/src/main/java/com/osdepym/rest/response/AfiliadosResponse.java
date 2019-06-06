package com.osdepym.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AfiliadosResponse {

	@JsonProperty
	private String telefonoCasa;
	@JsonProperty
	private String telefonoTrabajo;
	@JsonProperty
	private String email;
	
	public String getTelefonoCasa() {
		return telefonoCasa;
	}
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}
	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}
	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
