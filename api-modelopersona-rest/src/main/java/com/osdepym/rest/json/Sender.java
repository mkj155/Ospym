package com.osdepym.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sender {
	@JsonProperty
	 private String nombre;
	@JsonProperty
	 private String fechaHora;
	@JsonProperty
	 private String uid;


	 // Getter Methods 

	 public String getNombre() {
	  return nombre;
	 }

	 public String getFechaHora() {
	  return fechaHora;
	 }

	 public String getUid() {
	  return uid;
	 }

	 // Setter Methods 

	 public void setNombre(String nombre) {
	  this.nombre = nombre;
	 }

	 public void setFechaHora(String fechaHora) {
	  this.fechaHora = fechaHora;
	 }

	 public void setUid(String uid) {
	  this.uid = uid;
	 }
	}