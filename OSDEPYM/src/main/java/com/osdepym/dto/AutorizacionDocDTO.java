package com.osdepym.dto;

public class AutorizacionDocDTO {
	
	private Long id;	
	private Long idEspecialidad;
	private Long idPrestacion;
	private String documento;
	
	public AutorizacionDocDTO(Long id, Long idEspecialidad, Long idPrestacion, String documento) {
		this.id = id;
		this.idEspecialidad = idEspecialidad;
		this.idPrestacion = idPrestacion;
		this.documento = documento;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public Long getIdPrestacion() {
		return idPrestacion;
	}

	public void setIdPrestacion(Long idPrestacion) {
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
