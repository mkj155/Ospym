package com.osdepym.dto;

public class EspecialidadesDTO {
	private int id;
	private String etiqueta;
	
	public EspecialidadesDTO(int id, String etiqueta) {
		this.id = id;
		this.etiqueta = etiqueta;
	}
	
	public EspecialidadesDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}	
}
