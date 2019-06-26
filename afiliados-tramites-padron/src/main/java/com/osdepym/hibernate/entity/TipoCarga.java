package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vo_TipoCarga", schema = "ga")
public class TipoCarga {

	@Id
	@Column(name = "TipoCarga_ID", updatable = false, nullable = false)
	private Long tipoCargaId;
	
	@Column(name = "DescripcionTipoCarga", updatable = false)
	private String descripcionTipoCarga;
	
	@Column(name = "RequiereTipoAfiliado", updatable = false)
	private Integer requiereTipoAfiliado;
	
	@Column(name = "NombrePlantillaXLS", updatable = false)
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
