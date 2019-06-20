package com.osdepym.dto;

import java.util.List;

public class ResultadoImportarDTO {

	private List<AfiliadoImportDTO> afiliados;
	private String error;
	public List<AfiliadoImportDTO> getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(List<AfiliadoImportDTO> afiliados) {
		this.afiliados = afiliados;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
