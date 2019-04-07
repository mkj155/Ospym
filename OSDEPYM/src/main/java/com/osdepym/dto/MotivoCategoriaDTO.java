package com.osdepym.dto;

import com.osdepym.hibernate.entity.Categorias;
import com.osdepym.hibernate.entity.Motivos;

public class MotivoCategoriaDTO {
	
	private int idMotCat;
    private Motivos motivo;
    private Categorias categoria;
    private String correo;
	public int getIdMotCat() {
		return idMotCat;
	}
	public void setIdMotCat(int idMotCat) {
		this.idMotCat = idMotCat;
	}
	public Motivos getMotivo() {
		return motivo;
	}
	public void setMotivo(Motivos motivo) {
		this.motivo = motivo;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
