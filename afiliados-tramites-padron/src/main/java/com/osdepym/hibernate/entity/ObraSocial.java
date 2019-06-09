package com.osdepym.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vo_TipoCarga", schema = "ga")
public class ObraSocial {
	@Id
	@Column(name = "ObraSocial_ID", updatable = false, nullable = false)
	private Long obraSocialID;
	
	@Column(name = "DescripcionObraSocial", updatable = false)
	private String descripcionObraSocial;

	public ObraSocial() {}
	
	public Long getObraSocialID() {
		return obraSocialID;
	}

	public void setObraSocialID(Long obraSocialID) {
		this.obraSocialID = obraSocialID;
	}

	public String getDescripcionObraSocial() {
		return descripcionObraSocial;
	}

	public void setDescripcionObraSocial(String descripcionObraSocial) {
		this.descripcionObraSocial = descripcionObraSocial;
	}
}
