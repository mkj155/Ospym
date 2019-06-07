package com.osdepym.rest.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaFisicaRequest {

	@JsonProperty
	 private String apellido;
	@JsonProperty
	 private String nombre;
	@JsonProperty
	 private String fechaNacimiento;
	@JsonProperty
	 private String sexo;
	@JsonProperty
	 ArrayList < DocumentoIdentidad > documentoIdentidad = new ArrayList < DocumentoIdentidad > ();
	@JsonProperty("CUIL")
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

	 public void setSexo(String sexo) {
	  this.sexo = sexo;
	 }
	 @JsonProperty("CUIL")
	 public void setCUIL(Cuil CUIL) {
	  this.CUIL = CUIL;
	 }
	 
	 public void setDocumentoIdentidad(ArrayList < DocumentoIdentidad > documentoIdentidad) {
		 this.documentoIdentidad = documentoIdentidad;
	 }
	 
	 public ArrayList < DocumentoIdentidad > getDocumentoIdeantidad(){
		 return this.documentoIdentidad;
	 }

}