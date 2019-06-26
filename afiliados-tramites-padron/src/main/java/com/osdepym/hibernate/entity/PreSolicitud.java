package com.osdepym.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PreSolicitudesCargaMasiva", schema = "ga")
public class PreSolicitud {
	
	@Id
	@Column(name = "PreSolicitudesCargaMasiva_ID", updatable = false, nullable = false)
	private Long preSolicitudId;

	@Column(name = "Archivo_ID", updatable = false, nullable = false)
	private Long idArchivo;
	
	@Column(name = "CUIL", updatable = false)
	private Long cuil;
	
	@Column(name = "Apellido", updatable = false)
	private String apellido;
	
	@Column(name = "Nombre", updatable = false)
	private String nombre;
	
	@Column(name = "TipoDocumento", updatable = false)
	private String tipoDocumento;
	
	@Column(name = "NroDocumento", updatable = false)
	private String nroDocumento;
	
	@Column(name = "direccionCalle", updatable = false)
	private String direccionCalle;
	
	@Column(name = "DireccionNumero", updatable = false)
	private String direccionNumero;
	
	@Column(name = "DireccionPiso", updatable = false)
	private String direccionPiso;
	
	@Column(name = "DireccionDepartamento", updatable = false)
	private String direccionDepartamento;
	
	@Column(name = "DireccionLocalidad", updatable = false)
	private String direccionLocalidad;
	
	@Column(name = "DireccionProvincia", updatable = false)
	private String direccionProvincia;
	
	@Column(name = "DireccionCodigoPostal", updatable = false)
	private String direccionCodigoPostal;
	
	@Column(name = "Telefono", updatable = false)
	private String telefono;
	
	@Column(name = "Email", updatable = false)
	private String email;
	
	@Column(name = "FechaNacimiento", updatable = false)
	private String fechaNacimiento;
	
	@Column(name = "Sexo", updatable = false)
	private String sexo;
	
	@Column(name = "EstadoCivil", updatable = false)
	private String estadoCivil;

	@Column(name = "FechaInicioCobertura", updatable = false)
	private String fechaInicioCobertura;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ErrorValidacion_ID", updatable = false) 
	private ErrorValidacion errorValidacion;

	public Long getPreSolicitudId() {
		return preSolicitudId;
	}

	public void setPreSolicitudId(Long preSolicitudId) {
		this.preSolicitudId = preSolicitudId;
	}

	public Long getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
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

	public String getDireccionCalle() {
		return direccionCalle;
	}

	public void setDireccionCalle(String direccionCalle) {
		this.direccionCalle = direccionCalle;
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

	public String getDireccionCodigoPostal() {
		return direccionCodigoPostal;
	}

	public void setDireccionCodigoPostal(String direccionCodigoPostal) {
		this.direccionCodigoPostal = direccionCodigoPostal;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
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

	public String getFechaInicioCobertura() {
		return fechaInicioCobertura;
	}

	public void setFechaInicioCobertura(String fechaInicioCobertura) {
		this.fechaInicioCobertura = fechaInicioCobertura;
	}

	public ErrorValidacion getErrorValidacion() {
		return errorValidacion;
	}

	public void setErrorValidacion(ErrorValidacion errorValidacion) {
		this.errorValidacion = errorValidacion;
	}
	
	
	
}
