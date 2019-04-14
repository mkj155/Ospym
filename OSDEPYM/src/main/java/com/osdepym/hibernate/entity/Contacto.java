package com.osdepym.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CONTACTOS")
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
	
	private String comentario;
	
	@Column(name="FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	private String Correo;
	
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
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public String getCorreo() {
		return Correo;
	}
	
	public void setCorreo(String correo) {
		Correo = correo;
	}

}