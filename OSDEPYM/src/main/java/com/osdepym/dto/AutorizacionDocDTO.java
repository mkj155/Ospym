package com.osdepym.dto;

public class AutorizacionDocDTO {
	
	private int id;	
	private int idEspecialidad;
	private int idPrestacion;
	private String documento;
	
	public AutorizacionDocDTO(int id, int idEspecialidad, int idPrestacion, String documento) {
		this.id = id;
		this.idEspecialidad = idEspecialidad;
		this.idPrestacion = idPrestacion;
		this.documento = documento;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdPrestacion() {
		return idPrestacion;
	}

	public void setIdPrestacion(int idPrestacion) {
		this.idPrestacion = idPrestacion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public AutorizacionDocDTO() {}
	
}
