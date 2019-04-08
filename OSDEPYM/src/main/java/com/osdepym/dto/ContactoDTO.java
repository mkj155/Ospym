package com.osdepym.dto;

import java.util.Date;

public class ContactoDTO {

	private int idContacto;
	private String idtramite;
	private String idAfiliado;
	private int idMotivo;
	private int idCateg;
	private String nombreCompleto;
	private String comentario;
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
