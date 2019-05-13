package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACTOS", schema = "tramites_online")
public class Contacto {

	@Id
	@Column(name="ID_CONTACTO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;
	
	@Column(name="ID_TRAMITE")
	private String idTramite;
	
	@Column(name="ID_AFILIADO")
	private String idAfiliado;
	
	@Column(name="ID_MOTIVO")
	private int idMotivo;
	
	@Column(name="ID_CATEGORIA")
	private int idCategoria;
	
	@Column(name="NOMBRE_COMPLETO")
	private String nombreCompleto;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="ID_BENEF")
	private String idBenef;
	
	@Column(name="NOMBRE_BENEF")
	private String nombreBenef;
	
	@Column(name="ID_ESPECIALIDAD")
	private int idEspecialidad;
	
	@Column(name="ID_PRESTACION")
	private int idPrestacion;
	
	@Column(name="ID_PRESTADOR")
	private int idPrestador;
	
	private String comentario;
	
	private String correo;
	
	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	
	public String getIdtramite() {
		return idTramite;
	}
	
	public void setIdtramite(String idTramite) {
		this.idTramite = idTramite;
	}
	
	public String getIdAfiliado() {
		return idAfiliado;
	}
	
	public void setIdAfiliado(String idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public int getIdMotivo() {
		return idMotivo;
	}
	
	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getIdBenef() {
		return idBenef;
	}
	
	public void setIdBenef(String idBenef) {
		this.idBenef = idBenef;
	}
	
	public String getNombreBenef() {
		return nombreBenef;
	}
	
	public void setNombreBenef(String nombreBenef) {
		this.nombreBenef = nombreBenef;
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
	
	public int getIdPrestador() {
		return idPrestador;
	}
	
	public void setIdPrestador(int idPrestador) {
		this.idPrestador = idPrestador;
	}

}
