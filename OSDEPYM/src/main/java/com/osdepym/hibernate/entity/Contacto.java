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
	@Column(name="IDCONTACTO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;
	
	@Column(name="ID_TRAMITE")
	private String idtramite;
	
	@Column(name="ID_AFILIADO")
	private String idAfiliado;
	
	@Column(name="ID_MOTIVO")
	private int idMotivo;
	
	@Column(name="ID_CATEG")
	private int idCateg;
	
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
		return idtramite;
	}
	
	public void setIdtramite(String idtramite) {
		this.idtramite = idtramite;
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
	
	public int getIdCateg() {
		return idCateg;
	}
	
	public void setIdCateg(int idCateg) {
		this.idCateg = idCateg;
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