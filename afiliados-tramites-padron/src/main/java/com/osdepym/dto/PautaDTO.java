package com.osdepym.dto;

public class PautaDTO {

	private Long pautaId;
	private String CUIT;
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
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getPauta() {
		return pauta;
	}
	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
}
