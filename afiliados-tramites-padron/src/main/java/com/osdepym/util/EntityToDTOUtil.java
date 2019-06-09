package com.osdepym.util;

import org.springframework.beans.BeanUtils;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;
import com.osdepym.hibernate.entity.Pauta;
import com.osdepym.hibernate.entity.TipoAfiliado;
import com.osdepym.hibernate.entity.TipoCarga;

public abstract class EntityToDTOUtil {
	public static AfiliadoDTO entityToDTO(Afiliado entity) {
		AfiliadoDTO dto = new AfiliadoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static AfiliadoTableDTO entityToDTO2(Afiliado entity) {
		AfiliadoTableDTO dto = new AfiliadoTableDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static ObraSocialDTO entityToDTO(ObraSocial entity) {
		ObraSocialDTO dto = new ObraSocialDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static EstadoDTO entityToDTO(Estado entity) {
		EstadoDTO dto = new EstadoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static TipoCargaDTO entityToDTO(TipoCarga entity) {
		TipoCargaDTO dto = new TipoCargaDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static TipoAfiliadoDTO entityToDTO(TipoAfiliado entity) {
		TipoAfiliadoDTO dto = new TipoAfiliadoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static PautaDTO entityToDTO(Pauta entity) {
		PautaDTO dto = new PautaDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
