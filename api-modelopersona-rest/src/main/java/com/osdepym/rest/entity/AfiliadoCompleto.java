package com.osdepym.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vo_PersonaFisicaAfiliadoCompleto", schema = "mp")
public class AfiliadoCompleto {
	private Long personaId;
	private String apellido;
	private String nombre;
	private Date fechaNacimiento;
	private String sexo;
	private String CUIL;
	private Date fechaVigenciaDesdeCUIL;
	private String tipoDocumento;
	private Long nroDocumento;
	
	
	public AfiliadoCompleto () {}
	
	

	@Id
	@Column(name="Persona_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
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



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getCUIL() {
		return CUIL;
	}



	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}



	public Date getFechaVigenciaDesdeCUIL() {
		return fechaVigenciaDesdeCUIL;
	}



	public void setFechaVigenciaDesdeCUIL(Date fechaVigenciaDesdeCUIL) {
		this.fechaVigenciaDesdeCUIL = fechaVigenciaDesdeCUIL;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public Long getNroDocumento() {
		return nroDocumento;
	}



	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	
}
