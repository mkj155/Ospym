package com.osdepym.dto;

public class TipoCargaDTO {
	
	private Long tipoCargaId;
	private String descripcionTipoCarga;
	private Integer requiereTipoAfiliado;
	private String nombrePlantillaXLS;
	
	public Long getTipoCargaId() {
		return tipoCargaId;
	}
	public void setTipoCargaId(Long tipoCargaId) {
		this.tipoCargaId = tipoCargaId;
	}
	public String getDescripcionTipoCarga() {
		return descripcionTipoCarga;
	}
	public void setDescripcionTipoCarga(String descripcionTipoCarga) {
		this.descripcionTipoCarga = descripcionTipoCarga;
	}
	public Integer getRequiereTipoAfiliado() {
		return requiereTipoAfiliado;
	}
	public void setRequiereTipoAfiliado(Integer requiereTipoAfiliado) {
		this.requiereTipoAfiliado = requiereTipoAfiliado;
	}
	public String getNombrePlantillaXLS() {
		return nombrePlantillaXLS;
	}
	public void setNombrePlantillaXLS(String nombrePlantillaXLS) {
		this.nombrePlantillaXLS = nombrePlantillaXLS;
	}
	
	
}
