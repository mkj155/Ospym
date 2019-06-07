package com.osdepym.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Afiliado {
	@Id
	@Column(name = "registro_ID", updatable = false, nullable = false)
	String registroID;
	 
	@Column(name = "ObraSocial", updatable = false)
	String obraSocial;
	
	@Column(name = "TipoCarga", updatable = false)
	String tipoCarga;
	
	@Column(name = "TipoAfiliado", updatable = false)
	String tipoAfiliado;
	
	@Column(name = "CUIT", updatable = false)
	Long cuit;
	
	@Column(name = "CUIL", updatable = false)
	Long cuil;
	
	@Column(name = "Apellido", updatable = false)
	String apellido;
	
	@Column(name = "Nombre", updatable = false)
	String nombre;
	
	@Column(name = "TipoDocumento", updatable = false)
	String tipoDocumento;
	
	@Column(name = "NroDocumento", updatable = false)
	Long nroDocumento;
	
	@Column(name = "Direccion", updatable = false)
	String direccion;
	
	@Column(name = "DireccionNumero", updatable = false)
	int direccionNumero;
	
	@Column(name = "DireccionPiso", updatable = false)
	int direccionPiso;
	
	@Column(name = "DireccionDepartamento", updatable = false)
	String direccionDepartamento;
	
	@Column(name = "DireccionLocalidad", updatable = false)
	String direccionLocalidad;
	
	@Column(name = "DireccionProvincia", updatable = false)
	String direccionProvincia;
	
	@Column(name = "CodigoPostal", updatable = false)
	String codigoPostal;
	
	@Column(name = "Telefono", updatable = false)
	int telefono;
	
	@Column(name = "Email", updatable = false)
	String email;
	
	@Column(name = "FechaNacimiento", updatable = false)
	Date fechaNacimiento;
	
	@Column(name = "Sexo", updatable = false)
	String sexo;
	
	@Column(name = "EstadoCivil", updatable = false)
	String estadoCivil;
	
	@Column(name = "CUILTitular", updatable = false)
	String cuilTitular;
	
	@Column(name = "FechaInicio", updatable = false)
	Date fechaInicio;
	
	@Column(name = "CentroMedico", updatable = false)
	String centroMedico;
	
	@Column(name = "CodigoPlan", updatable = false)
	String plan;
	
	@Column(name = "Estado", updatable = false)
	Long estado;
	
	@Column(name = "Solicitud_ID", updatable = false)
	Long solicitudID;
	
	@Column(name = "Archivo", updatable = false)
	String archivo;
	
	@Column(name = "FechaCarga", updatable = false)
	Date fechaCarga;
	
	@Column(name = "CodigoError", updatable = false)
	String codigoError;
	
	@Column(name = "DescripcionError", updatable = false)
	String descripcionError;
	
	@Column(name = "EstadoRegistro_ID", updatable = false)
	Long estadoRegistroID;
	
	@Column(name = "ObraSocial_ID", updatable = false)
	Long obraSocialID;
	
	@Column(name = "TipoCarga_ID", updatable = false)
	Long tipoCargaID;
	
	@Column(name = "TipoAfiliado_ID", updatable = false)
	Long tipoAfiliadoID;
	
	@Column(name = "EstadoCivil_ID", updatable = false)
	Long estadoCivilID;
	
	@Column(name = "Provincia_ID", updatable = false)
	Long provinciaID;
	
	@Column(name = "Localidad_ID", updatable = false)
	Long localidadID;

	public Afiliado() {}

	public String getRegistroID() {
	  return this.registroID;
	}

	public void setRegistroID(String value) {
	  this.registroID = value;
	}

	public String getObraSocial() {
	  return this.obraSocial;
	}

	public void setObraSocial(String value) {
	  this.obraSocial = value;
	}

	public String getTipoCarga() {
	  return this.tipoCarga;
	}

	public void setTipoCarga(String value) {
	  this.tipoCarga = value;
	}

	public String getTipoAfiliado() {
	  return this.tipoAfiliado;
	}

	public void setTipoAfiliado(String value) {
	  this.tipoAfiliado = value;
	}

	public Long getCuit() {
	  return this.cuit;
	}

	public void setCuit(Long value) {
	  this.cuit = value;
	}

	public Long getCuil() {
	  return this.cuil;
	}

	public void setCuil(Long value) {
	  this.cuil = value;
	}

	public String getApellido() {
	  return this.apellido;
	}

	public void setApellido(String value) {
	  this.apellido = value;
	}

	public String getNombre() {
	  return this.nombre;
	}

	public void setNombre(String value) {
	  this.nombre = value;
	}

	public String getTipoDocumento() {
	  return this.tipoDocumento;
	}

	public void setTipoDocumento(String value) {
	  this.tipoDocumento = value;
	}

	public Long getNroDocumento() {
	  return this.nroDocumento;
	}

	public void setNroDocumento(Long value) {
	  this.nroDocumento = value;
	}

	public String getDireccion() {
	  return this.direccion;
	}

	public void setDireccion(String value) {
	  this.direccion = value;
	}

	public int getDireccionNumero() {
	  return this.direccionNumero;
	}

	public void setDireccionNumero(int value) {
	  this.direccionNumero = value;
	}

	public int getDireccionPiso() {
	  return this.direccionPiso;
	}

	public void setDireccionPiso(int value) {
	  this.direccionPiso = value;
	}

	public String getDireccionDepartamento() {
	  return this.direccionDepartamento;
	}

	public void setDireccionDepartamento(String value) {
	  this.direccionDepartamento = value;
	}

	public String getDireccionLocalidad() {
	  return this.direccionLocalidad;
	}

	public void setDireccionLocalidad(String value) {
	  this.direccionLocalidad = value;
	}

	public String getDireccionProvincia() {
	  return this.direccionProvincia;
	}

	public void setDireccionProvincia(String value) {
	  this.direccionProvincia = value;
	}

	public String getCodigoPostal() {
	  return this.codigoPostal;
	}

	public void setCodigoPostal(String value) {
	  this.codigoPostal = value;
	}

	public int getTelefono() {
	  return this.telefono;
	}

	public void setTelefono(int value) {
	  this.telefono = value;
	}

	public String getEmail() {
	  return this.email;
	}

	public void setEmail(String value) {
	  this.email = value;
	}

	public Date getFechaNacimiento() {
	  return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date value) {
	  this.fechaNacimiento = value;
	}

	public String getSexo() {
	  return this.sexo;
	}

	public void setSexo(String value) {
	  this.sexo = value;
	}

	public String getEstadoCivil() {
	  return this.estadoCivil;
	}

	public void setEstadoCivil(String value) {
	  this.estadoCivil = value;
	}

	public String getCuilTitular() {
	  return this.cuilTitular;
	}

	public void setCuilTitular(String value) {
	  this.cuilTitular = value;
	}

	public Date getFechaInicio() {
	  return this.fechaInicio;
	}

	public void setFechaInicio(Date value) {
	  this.fechaInicio = value;
	}

	public String getCentroMedico() {
	  return this.centroMedico;
	}

	public void setCentroMedico(String value) {
	  this.centroMedico = value;
	}

	public String getPlan() {
	  return this.plan;
	}

	public void setPlan(String value) {
	  this.plan = value;
	}

	public Long getEstado() {
	  return this.estado;
	}

	public void setEstado(Long value) {
	  this.estado = value;
	}

	public Long getSolicitudID() {
	  return this.solicitudID;
	}

	public void setSolicitudID(Long value) {
	  this.solicitudID = value;
	}

	public String getArchivo() {
	  return this.archivo;
	}

	public void setArchivo(String value) {
	  this.archivo = value;
	}

	public Date getFechaCarga() {
	  return this.fechaCarga;
	}

	public void setFechaCarga(Date value) {
	  this.fechaCarga = value;
	}

	public String getCodigoError() {
	  return this.codigoError;
	}

	public void setCodigoError(String value) {
	  this.codigoError = value;
	}

	public String getDescripcionError() {
	  return this.descripcionError;
	}

	public void setDescripcionError(String value) {
	  this.descripcionError = value;
	}

	public Long getEstadoRegistroID() {
	  return this.estadoRegistroID;
	}

	public void setEstadoRegistroID(Long value) {
	  this.estadoRegistroID = value;
	}

	public Long getObraSocialID() {
	  return this.obraSocialID;
	}

	public void setObraSocialID(Long value) {
	  this.obraSocialID = value;
	}

	public Long getTipoCargaID() {
	  return this.tipoCargaID;
	}

	public void setTipoCargaID(Long value) {
	  this.tipoCargaID = value;
	}

	public Long getTipoAfiliadoID() {
	  return this.tipoAfiliadoID;
	}

	public void setTipoAfiliadoID(Long value) {
	  this.tipoAfiliadoID = value;
	}

	public Long getEstadoCivilID() {
	  return this.estadoCivilID;
	}

	public void setEstadoCivilID(Long value) {
	  this.estadoCivilID = value;
	}

	public Long getProvinciaID() {
	  return this.provinciaID;
	}

	public void setProvinciaID(Long value) {
	  this.provinciaID = value;
	}

	public Long getLocalidadID() {
	  return this.localidadID;
	}

	public void setLocalidadID(Long value) {
	  this.localidadID = value;
	}
}
