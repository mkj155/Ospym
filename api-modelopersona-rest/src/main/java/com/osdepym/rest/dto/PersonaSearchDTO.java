package com.osdepym.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaSearchDTO {
	private String apellido; 
	@JsonProperty
	private String nombre; 
	@JsonProperty
	private String sexo;
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@JsonProperty
	private DniDTO documentoIdentidad;
	@JsonProperty
	private List<CuilDTO> CUIL;
	
	public PersonaSearchDTO() {}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public DniDTO getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(DniDTO documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public List<CuilDTO> getCUIL() {
		return CUIL;
	}

	public void setCUIL(List<CuilDTO> CUIL) {
		this.CUIL = CUIL;
	}
}