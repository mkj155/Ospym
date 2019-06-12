package com.osdepym.dto;

import java.sql.Timestamp;

public class AfiliadoTableDTO {
	int registroID;
	String obraSocial;
	String tipoCarga;
	String tipoAfiliado;
	Long cuit;
	Long cuil;
	String apellido;
	String nombre;
	String tipoDocumento;
	String nroDocumento;
	Timestamp fechaNacimiento;
	String sexo;
	String estadoCivil;
	Long cuilTitular;
	Timestamp fechaInicio;
	String centroMedico;
	String plan;
	String estado;
	Integer solicitudID;
	String archivo;
	Timestamp fechaCarga;
	Integer codigoError;
	String descripcionError;
	boolean anular;
	String errorConfirmar;
	String messageErrorConfirmar;
	String errorAnular;
	String messageErrorAnular;
	   
	public String getErrorAnular() {
		return errorAnular;
	}

	public void setErrorAnular(String errorAnular) {
		this.errorAnular = errorAnular;
	}

	public String getMessageErrorAnular() {
		return messageErrorAnular;
	}

	public void setMessageErrorAnular(String messageErrorAnular) {
		this.messageErrorAnular = messageErrorAnular;
	}

	public AfiliadoTableDTO() {}

	public int getRegistroID() {
		return registroID;
	}

	public void setRegistroID(int registroID) {
		this.registroID = registroID;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public String getTipoAfiliado() {
		return tipoAfiliado;
	}

	public void setTipoAfiliado(String tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Long getCuilTitular() {
		return cuilTitular;
	}

	public void setCuilTitular(Long cuilTitular) {
		this.cuilTitular = cuilTitular;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(String centroMedico) {
		this.centroMedico = centroMedico;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getSolicitudID() {
		return solicitudID;
	}

	public void setSolicitudID(Integer solicitudID) {
		this.solicitudID = solicitudID;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Timestamp getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Timestamp fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	
	public boolean isAnular() {
		return anular;
	}

	public void setAnular(boolean anular) {
		this.anular = anular;
	}
	
	public String getErrorConfirmar() {
		return errorConfirmar;
	}

	public void setErrorConfirmar(String errorConfirmar) {
		this.errorConfirmar = errorConfirmar;
	}

	public String getMessageErrorConfirmar() {
		return messageErrorConfirmar;
	}

	public void setMessageErrorConfirmar(String messageErrorConfirmar) {
		this.messageErrorConfirmar = messageErrorConfirmar;
	}
}
