package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cuil {
	@JsonProperty
	 private String id;
	@JsonProperty
	 private String fechaInicio;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public String getFechaInicio() {
	  return fechaInicio;
	 }

	 // Setter Methods 

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setFechaInicio(String fechaInicio) {
	  this.fechaInicio = fechaInicio;
	 }
	}