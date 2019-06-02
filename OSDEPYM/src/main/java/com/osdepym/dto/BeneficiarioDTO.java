package com.osdepym.dto;

public class BeneficiarioDTO {
	private Long id;
	private Long titular;
	private String apellido;
	private String nombre;
	private String nombreCompleto;
	
	public BeneficiarioDTO(Long id, Long titular, String apellido, String nombre) {
		this.id = id;
		this.titular = titular;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nombreCompleto = new StringBuilder().append(apellido).append(" ").append(nombre).toString();
	}
	
	public BeneficiarioDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTitular() {
		return titular;
	}

	public void setTitular(Long titular) {
		this.titular = titular;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreCompleto() {
		return this.nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
}
