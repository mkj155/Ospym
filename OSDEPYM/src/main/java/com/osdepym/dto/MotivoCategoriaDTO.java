package com.osdepym.dto;

import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Motivo;

public class MotivoCategoriaDTO {
	
	private Long idMotCat;
    private Motivo motivo;
    private Categoria categoria;
    private String correo;
	public Long getIdMotCat() {
		return idMotCat;
	}
	public void setIdMotCat(Long idMotCat) {
		this.idMotCat = idMotCat;
	}
	public Motivo getMotivo() {
		return motivo;
	}
	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
