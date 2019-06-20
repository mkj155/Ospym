package com.osdepym.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.osdepym.dto.AfiliadoImportDTO;

public class ImportForm {
	private Long obraSocialId;
	private Long tipoCargaId;	
	private Long tipoAfiliadoId;
	private String cuit;
	private Long pautaId;
	private List<AfiliadoImportDTO> afiliados;
	private MultipartFile uploadFile;
	private Long idArchivo;
	

	
	
	public Long getObraSocialId() {
		return obraSocialId;
	}
	public void setObraSocialId(Long obraSocialId) {
		this.obraSocialId = obraSocialId;
	}
	public Long getTipoCargaId() {
		return tipoCargaId;
	}
	public void setTipoCargaId(Long tipoCargaId) {
		this.tipoCargaId = tipoCargaId;
	}
	public Long getTipoAfiliadoId() {
		return tipoAfiliadoId;
	}
	public void setTipoAfiliadoId(Long tipoAfiliadoId) {
		this.tipoAfiliadoId = tipoAfiliadoId;
	}
	public Long getPautaId() {
		return pautaId;
	}
	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	

	public List<AfiliadoImportDTO> getAfiliados() {
		return afiliados;
	}


	public void setAfiliados(List<AfiliadoImportDTO> afiliados) {
		this.afiliados = afiliados;
	}


	public MultipartFile getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public Long getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

}
