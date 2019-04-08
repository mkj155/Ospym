package com.osdepym.dto;

import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Motivo;

public class MotivoCategoriaDTO {
	
	private int idMotCat;
    private Motivo motivo;
    private Categoria categoria;
    private String correo;
	public int getIdMotCat() {
		return idMotCat;
	}
	public void setIdMotCat(int idMotCat) {
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
