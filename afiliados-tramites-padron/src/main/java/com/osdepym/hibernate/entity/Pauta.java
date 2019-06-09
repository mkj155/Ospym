package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vo_Pauta", schema = "ga")
public class Pauta {

	@Id
	@Column(name = "Pauta_ID", updatable = false, nullable = false)
	private Long pautaId;
	
	@Column(name = "CUIT", updatable = false)
	private String CUIT;
	
	@Column(name = "Pauta", updatable = false)
	private String pauta;
	
	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String CUIT) {
		this.CUIT = CUIT;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

}
