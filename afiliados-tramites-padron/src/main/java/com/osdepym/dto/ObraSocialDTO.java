package com.osdepym.dto;

public class ObraSocialDTO {
	private Long obraSocialID;
	private String descripcionObraSocial;
	
	public ObraSocialDTO() {}

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
