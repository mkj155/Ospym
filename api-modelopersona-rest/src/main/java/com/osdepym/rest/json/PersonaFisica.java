package com.osdepym.rest.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaFisica {
	@JsonProperty
	 private String apellido;
	@JsonProperty
	 private String nombre;
	@JsonProperty
	 private String fechaNacimiento;
	@JsonProperty
	 private String Sexo;
	@JsonProperty
	 ArrayList < DocumentoIdentidad > documentoIdentidad = new ArrayList < DocumentoIdentidad > ();
	@JsonProperty
	 Cuil cuil;


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
	  return Sexo;
	 }

	 public Cuil getCUIL() {
	  return cuil;
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

	 public void setSexo(String Sexo) {
	  this.Sexo = Sexo;
	 }

	 public void setCUIL(Cuil cuil) {
	  this.cuil = cuil;
	 }
	}