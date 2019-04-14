package com.osdepym.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria {
	
	private int idCategoria;
	private String etiqueta;
	private Set<MotivoCategoria> motivoCategorias = new HashSet<MotivoCategoria>();
	
	public Categoria () {}
	
	public Categoria(String etiquetas) {
		this.etiqueta = etiquetas;
	}

	public Categoria(String etiquetas, Set<MotivoCategoria> motivoCategorias) {
		this.etiqueta = etiquetas;
		this.motivoCategorias = motivoCategorias;
	}

	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@OneToMany(mappedBy = "categoria")
	public Set<MotivoCategoria> getMotivoCategorias() {
		return motivoCategorias;
	}

	public void setMotivoCategorias(Set<MotivoCategoria> motivoCategorias) {
		this.motivoCategorias = motivoCategorias;
	}
	
	public void addMotivoCategoria(MotivoCategoria motivoCategorias) {
		this.motivoCategorias.add(motivoCategorias);
	}

}