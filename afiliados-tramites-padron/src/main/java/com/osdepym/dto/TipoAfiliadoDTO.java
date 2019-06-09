package com.osdepym.dto;

public class TipoAfiliadoDTO {

	private Long tipoAfiliadoId;
	private String descripcionTipoAfiliado;
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
	public Integer getRequiereCUIT() {
		return requiereCUIT;
	}
	public void setRequiereCUIT(Integer requiereCUIT) {
		this.requiereCUIT = requiereCUIT;
	}
}
