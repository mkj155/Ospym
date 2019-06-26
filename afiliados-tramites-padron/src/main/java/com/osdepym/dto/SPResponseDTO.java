package com.osdepym.dto;

public class SPResponseDTO {

	private Long idArchivo;
	private String error;
	private String mensaje;
	
	public SPResponseDTO() {
	}
	
	public SPResponseDTO(String error, String mensaje) {
		this.error = error;
		this.mensaje = mensaje;
	}
	public SPResponseDTO(String error, String mensaje, Long idArchivo) {
		this.error = error;
		this.mensaje = mensaje;
		this.idArchivo = idArchivo;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Long getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}
	
	
}
