package com.osdepym.rest.response;

import java.util.List;

import com.osdepym.dto.BeneficiarioDTO;

public class BeneficiariosResponse {

	private List<BeneficiarioDTO> beneficiarios;

	public BeneficiariosResponse() {
	}
	
	public BeneficiariosResponse(List<BeneficiarioDTO> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
	public List<BeneficiarioDTO> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<BeneficiarioDTO> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
}
