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
@Table(name = "CATEG_CONTACTO")
public class Categorias {
	
	private int idCateg;
	private String etiqueta;
	private Set<MotivoCategoria> motivoCategorias = new HashSet<MotivoCategoria>();
	
	public Categorias () {}
	
	public Categorias(String etiquetas) {
		this.etiqueta = etiquetas;
	}

	public Categorias(String etiquetas, Set<MotivoCategoria> motivoCategorias) {
		this.etiqueta = etiquetas;
		this.motivoCategorias = motivoCategorias;
	}

	@Id
	@Column(name="IDCATEG")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(int idCateg) {
		this.idCateg = idCateg;
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
	
	public void addMotivoCategoria(MotivoCategoria motivoCategoria) {
		this.motivoCategorias.add(motivoCategoria);
	}

}
