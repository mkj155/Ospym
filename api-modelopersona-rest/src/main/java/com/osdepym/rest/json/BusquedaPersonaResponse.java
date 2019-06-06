package com.osdepym.rest.json;

import java.util.ArrayList;

public class BusquedaPersonaResponse {
	 private boolean encontrada;
	 private Mensaje MensajeObject;
	 private float cantidad;
	 private ArrayList < PersonaFisicaResponse > personas = new ArrayList < PersonaFisicaResponse > ();


	 // Getter Methods 

	 public boolean getEncontrada() {
	  return encontrada;
	 }

	 public Mensaje getMensaje() {
	  return MensajeObject;
	 }

	 public float getCantidad() {
	  return cantidad;
	 }

	 // Setter Methods 

	 public void setEncontrada(boolean encontrada) {
	  this.encontrada = encontrada;
	 }

	 public void setMensaje(Mensaje mensajeObject) {
	  this.MensajeObject = mensajeObject;
	 }

	 public void setCantidad(float cantidad) {
	  this.cantidad = cantidad;
	 }

	public ArrayList < PersonaFisicaResponse > getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList < PersonaFisicaResponse > personas) {
		this.personas = personas;
	}
	}