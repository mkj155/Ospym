package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vo_TipoAfiliado", schema = "ga")
public class TipoAfiliado {

	@Id
	@Column(name = "TipoAfiliado_ID", updatable = false, nullable = false)
	private Long tipoAfiliadoId;
	
	@Column(name = "DescripcionTipoAfiliado", updatable = false)
	private String descripcionTipoAfiliado;
	
	@Column(name = "RequiereCUIT", updatable = false)
	private Integer requiereCUIT;
	
	public Long getTipoAfiliadoId() {
		return tipoAfiliadoId;
	}

	public void setTipoAfiliadoId(Long tipoAfiliadoId) {
		this.tipoAfiliadoId = tipoAfiliadoId;
	}

	public String getDescripcionTipoAfiliado() {
		return descripcionTipoAfiliado;
	}

	public void setDescripcionTipoAfiliado(String descripcionTipoAfiliado) {
		this.descripcionTipoAfiliado = descripcionTipoAfiliado;
	}

	public Integer getRequiereTipoAfiliado() {
		return requiereCUIT;
	}

	public void setRequiereCUIT(Integer requiereCUIT) {
		this.requiereCUIT = requiereCUIT;
	}


	


}
