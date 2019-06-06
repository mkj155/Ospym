package com.osdepym.rest.json;

public class ActualizacionPersonaResponse {
	private boolean encontrada;
	 private Mensaje MensajeObject;


	 // Getter Methods 

	 public boolean getEncontrada() {
	  return encontrada;
	 }

	 public Mensaje getMensaje() {
	  return MensajeObject;
	 }

	 // Setter Methods 

	 public void setEncontrada(boolean encontrada) {
	  this.encontrada = encontrada;
	 }

	 public void setMensaje(Mensaje mensajeObject) {
	  this.MensajeObject = mensajeObject;
	 }

}
