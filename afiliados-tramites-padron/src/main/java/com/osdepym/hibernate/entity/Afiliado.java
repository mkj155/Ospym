package com.osdepym.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Afiliado {
	@Id
	@Column(name = "registro_ID", updatable = false, nullable = false)
	int registroID;
	 
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
	String nroDocumento;
	
	@Column(name = "Direccion", updatable = false)
	String direccion;
	
	@Column(name = "DireccionNumero", updatable = false)
	String direccionNumero;
	
	@Column(name = "DireccionPiso", updatable = false)
	String direccionPiso;
	
	@Column(name = "DireccionDepartamento", updatable = false)
	String direccionDepartamento;
	
	@Column(name = "DireccionLocalidad", updatable = false)
	String direccionLocalidad;
	
	@Column(name = "DireccionProvincia", updatable = false)
	String direccionProvincia;
	
	@Column(name = "CodigoPostal", updatable = false)
	String codigoPostal;
	
	@Column(name = "Telefono", updatable = false)
	String telefono;
	
	@Column(name = "Email", updatable = false)
	String email;
	
	@Column(name = "FechaNacimiento", updatable = false)
	Timestamp fechaNacimiento;
	
	@Column(name = "Sexo", updatable = false)
	String sexo;
	
	@Column(name = "EstadoCivil", updatable = false)
	String estadoCivil;
	
	@Column(name = "CUILTitular", updatable = false)
	Long cuilTitular;
	
	@Column(name = "FechaInicio", updatable = false)
	Timestamp fechaInicio;
	
	@Column(name = "CentroMedico", updatable = false)
	String centroMedico;
	
	@Column(name = "CodigoPlan", updatable = false)
	String plan;
	
	@Column(name = "Estado", updatable = false)
	String estado;
	
	@Column(name = "Solicitud_ID", updatable = false)
	Integer solicitudID;
	
	@Column(name = "Archivo", updatable = false)
	String archivo;
	
	@Column(name = "FechaCarga", updatable = false)
	Timestamp fechaCarga;
	
	@Column(name = "CodigoError", updatable = false)
	Integer codigoError;
	
	@Column(name = "DescripcionError", updatable = false)
	String descripcionError;
	
	@Column(name = "EstadoRegistro_ID", updatable = false)
	Integer estadoRegistroID;
	
	@Column(name = "ObraSocial_ID", updatable = false)
	Integer obraSocialID;
	
	@Column(name = "TipoCarga_ID", updatable = false)
	Integer tipoCargaID;
	
	@Column(name = "TipoAfiliado_ID", updatable = false)
	Integer tipoAfiliadoID;
	
	@Column(name = "EstadoCivil_ID", updatable = false)
	Integer estadoCivilID;
	
	@Column(name = "Provincia_ID", updatable = false)
	Integer provinciaID;
	
	@Column(name = "Localidad_ID", updatable = false)
	Integer localidadID;

	public Afiliado() {}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccionNumero() {
		return direccionNumero;
	}

	public void setDireccionNumero(String direccionNumero) {
		this.direccionNumero = direccionNumero;
	}

	public String getDireccionPiso() {
		return direccionPiso;
	}

	public void setDireccionPiso(String direccionPiso) {
		this.direccionPiso = direccionPiso;
	}

	public String getDireccionDepartamento() {
		return direccionDepartamento;
	}

	public void setDireccionDepartamento(String direccionDepartamento) {
		this.direccionDepartamento = direccionDepartamento;
	}

	public String getDireccionLocalidad() {
		return direccionLocalidad;
	}

	public void setDireccionLocalidad(String direccionLocalidad) {
		this.direccionLocalidad = direccionLocalidad;
	}

	public String getDireccionProvincia() {
		return direccionProvincia;
	}

	public void setDireccionProvincia(String direccionProvincia) {
		this.direccionProvincia = direccionProvincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getEstadoRegistroID() {
		return estadoRegistroID;
	}

	public void setEstadoRegistroID(Integer estadoRegistroID) {
		this.estadoRegistroID = estadoRegistroID;
	}

	public Integer getObraSocialID() {
		return obraSocialID;
	}

	public void setObraSocialID(Integer obraSocialID) {
		this.obraSocialID = obraSocialID;
	}

	public Integer getTipoCargaID() {
		return tipoCargaID;
	}

	public void setTipoCargaID(Integer tipoCargaID) {
		this.tipoCargaID = tipoCargaID;
	}

	public Integer getTipoAfiliadoID() {
		return tipoAfiliadoID;
	}

	public void setTipoAfiliadoID(Integer tipoAfiliadoID) {
		this.tipoAfiliadoID = tipoAfiliadoID;
	}

	public Integer getEstadoCivilID() {
		return estadoCivilID;
	}

	public void setEstadoCivilID(Integer estadoCivilID) {
		this.estadoCivilID = estadoCivilID;
	}

	public Integer getProvinciaID() {
		return provinciaID;
	}

	public void setProvinciaID(Integer provinciaID) {
		this.provinciaID = provinciaID;
	}

	public Integer getLocalidadID() {
		return localidadID;
	}

	public void setLocalidadID(Integer localidadID) {
		this.localidadID = localidadID;
	}
}
