package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS", schema = "tramites_online")
public class Categoria {
	
	private Long idCategoria;
	private String etiqueta;
	
	public Categoria () {}

	public Categoria(String etiquetas) {
		this.etiqueta = etiquetas;
	}

	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}


}
