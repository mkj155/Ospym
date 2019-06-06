package com.osdepym.util;

import org.springframework.beans.BeanUtils;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;

public abstract class EntityToDTOUtil {
	public static AfiliadoDTO entityToDTO(Afiliado entity) {
		AfiliadoDTO dto = new AfiliadoDTO();
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
}
