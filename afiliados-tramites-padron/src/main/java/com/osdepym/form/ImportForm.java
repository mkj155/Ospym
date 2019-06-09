package com.osdepym.form;

public class ImportForm {
	private String obraSocial;
	private String tipoCarga;
	public String getTipoAfiliado() {
		return tipoAfiliado;
	}


	public void setTipoAfiliado(String tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public String getPauta() {
		return pauta;
	}


	public void setPauta(String pauta) {
		this.pauta = pauta;
	}


	private String tipoAfiliado;
	private String cuit;
	private String pauta;
	
	
	public ImportForm() {}


	public String getObraSocial() {
		return obraSocial;
	}


	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}


	public String getTipoCarga() {
		return tipoCarga;
	}


	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	

}
