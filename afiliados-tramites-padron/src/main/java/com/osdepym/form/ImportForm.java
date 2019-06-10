package com.osdepym.form;

import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;

public class ImportForm {
	private ObraSocialDTO obraSocial;
	private TipoCargaDTO tipoCarga;	
	private TipoAfiliadoDTO tipoAfiliado;
	private String cuit;
	private PautaDTO pauta;
	private String cuil;
	private String apellido;
	private String nombre;
	private String tipoDocumento;
	private String nroDocumento;
	private String direccionCalle;
	private String direccionNumero;
	private String direccionPiso;
	private String direccionDepartamento;
	private String direccionLocalidad;
	private String direccionProvincia;
	private String direccionCodigoPostal;
	private String direccionTelefono;
	private String fechaNacimiento;
	private String sexo;
	private String estadoCivil;
	private String fechaInicioCobertura;
	private String email;

	
	public TipoAfiliadoDTO getTipoAfiliado() {
		return tipoAfiliado;
	}


	public void setTipoAfiliado(TipoAfiliadoDTO tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public PautaDTO getPauta() {
		return pauta;
	}
	public void setPauta(PautaDTO pauta) {
		this.pauta = pauta;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
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
	public String getDireccionTelefono() {
		return direccionTelefono;
	}
	public void setDireccionTelefono(String direccionTelefono) {
		this.direccionTelefono = direccionTelefono;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
