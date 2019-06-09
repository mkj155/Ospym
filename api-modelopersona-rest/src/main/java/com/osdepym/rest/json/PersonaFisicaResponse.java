package com.osdepym.rest.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaFisicaResponse {

	@JsonProperty
	private Long personaID;
	@JsonProperty
	 private String apellido = "";
	@JsonProperty
	 private String nombre = "";
	@JsonProperty
	 private String fechaNacimiento = "";
	@JsonProperty("Sexo")
	 private String sexo = "";
	@JsonProperty("documentoIdentidad")
	 ArrayList < DocumentoIdentidad > documentoIdentidad;
	@JsonProperty
	 Cuil CUIL = new Cuil();


	 // Getter Methods 

	 public String getApellido() {
	  return apellido;
	 }

	 public String getNombre() {
	  return nombre;
	 }

	 public String getFechaNacimiento() {
	  return fechaNacimiento;
	 }

	 public String getSexo() {
	  return sexo;
	 }
	 @JsonProperty("CUIL")
	 public Cuil getCUIL() {
	  return CUIL;
	 }

	 // Setter Methods 
	
	 public void setApellido(String apellido) {
	  this.apellido = apellido;
	 }

	 public void setNombre(String nombre) {
	  this.nombre = nombre;
	 }

	 public void setFechaNacimiento(String fechaNacimiento) {
	  this.fechaNacimiento = fechaNacimiento;
	 }
	 @JsonProperty("Sexo")
	 public void setSexo(String sexo) {
	  this.sexo = sexo;
	 }
	 @JsonProperty("CUIL")
	 public void setCUIL(Cuil CUIL) {
	  this.CUIL = CUIL;
	 }
	 @JsonProperty("documentoIdentidad")
	 public void setDocumentoIdentidad(ArrayList < DocumentoIdentidad > documentoIdentidad) {
		 this.documentoIdentidad = documentoIdentidad;
	 }
	 @JsonProperty("documentoIdentidad")
	 public ArrayList < DocumentoIdentidad > getDocumentoIdeantidad(){
		 return this.documentoIdentidad;
	 }

	public Long getPersonaID() {
		return personaID;
	}

	public void setPersonaID(Long personaID) {
		this.personaID = personaID;
	}
}
