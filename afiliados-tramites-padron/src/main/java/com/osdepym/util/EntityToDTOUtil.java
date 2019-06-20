package com.osdepym.util;

import java.text.SimpleDateFormat;

import org.springframework.beans.BeanUtils;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoImportDTO;
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
import com.osdepym.hibernate.entity.PreSolicitud;
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
	
	public static AfiliadoImportDTO entityToDTO(PreSolicitud entity) {
		AfiliadoImportDTO dto = new AfiliadoImportDTO();
		dto.setIdArchivo(entity.getIdArchivo());
		dto.setCuil(String.valueOf(entity.getCuil()));
		dto.setApellido(entity.getApellido());
		dto.setNombre(entity.getNombre());
		dto.setDireccion(entity.getDireccionCalle());
		dto.setNumero(entity.getDireccionNumero());
		dto.setPiso(entity.getDireccionPiso());
		dto.setDepartamento(entity.getDireccionDepartamento());
		dto.setLocalidad(entity.getDireccionLocalidad());
		dto.setProvincia(entity.getDireccionProvincia());
		dto.setCodigoPostal(entity.getDireccionCodigoPostal());
		dto.setTelefono(entity.getTelefono());
		dto.setFechaNacimiento(entity.getFechaNacimiento());
		dto.setSexo(entity.getSexo());
		dto.setEstadoCivil(entity.getEstadoCivil());
		dto.setFechaInicioCobertura(entity.getFechaInicioCobertura());
		dto.setEmail(entity.getEmail());
		dto.setErrorMensaje(entity.getErrorValidacion().getDescripcion());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
