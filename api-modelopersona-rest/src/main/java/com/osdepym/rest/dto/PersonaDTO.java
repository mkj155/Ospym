package com.osdepym.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaDTO extends PersonaSearchDTO {
	@JsonProperty
	private Long personaID;
	
	public PersonaDTO() {}
	
	public Long getPersonaID() {
		return personaID;
	}
	public void setPersonaID(Long personaID) {
		this.personaID = personaID;
	}
}