package com.osdepym.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoImportDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;

public class ImportForm {
	private ObraSocialDTO obraSocial;
	private TipoCargaDTO tipoCarga;	
	private TipoAfiliadoDTO tipoAfiliado;
	private String cuit;
	private PautaDTO pauta;
	private List<AfiliadoImportDTO> afiliados;
	private MultipartFile uploadFile;
	

	
	public TipoAfiliadoDTO getTipoAfiliado() {
		return tipoAfiliado;
	}


	public void setTipoAfiliado(TipoAfiliadoDTO tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public PautaDTO getPauta() {
		return pauta;
	}
	public void setPauta(PautaDTO pauta) {
		this.pauta = pauta;
	}


	public ObraSocialDTO getObraSocial() {
		return obraSocial;
	}


	public void setObraSocial(ObraSocialDTO obraSocial) {
		this.obraSocial = obraSocial;
	}


	public TipoCargaDTO getTipoCarga() {
		return tipoCarga;
	}


	public void setTipoCarga(TipoCargaDTO tipoCarga) {
		this.tipoCarga = tipoCarga;
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

}
