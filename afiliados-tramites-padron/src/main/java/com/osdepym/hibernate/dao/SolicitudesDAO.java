package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.dto.AfiliadoImportDTO;
import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.SPResponseDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;
import com.osdepym.hibernate.entity.PreSolicitud;

public interface SolicitudesDAO extends Dao<Afiliado>{
	public List<Afiliado> buscar(SolicitudesForm form) throws CustomException;
	public List<ObraSocial> getAllObrasSociales() throws CustomException;
	public List<Estado> getAllEstados() throws CustomException;
	public Integer obtenerSolicitudMultiple() throws CustomException;
	public String[] confirmarAltaAfiliado(Integer id) throws CustomException;
	public SPResponseDTO archivoCargaMasivaCargarRegistro(Long archivoId, AfiliadoImportDTO afiliado) throws CustomException;
	public SPResponseDTO archivoCargaMasivaObtenerIdentificar(Long obraSocial, Long tipoCarga, Long tipoAfiliado, String cuit, Long pauta, String nombreArchivo) throws CustomException;
	public String[] anularAfiliado(AfiliadoTableDTO afiliado) throws CustomException;
	public SPResponseDTO archivoCargaMasivaConfirmar(Long archivoId) throws CustomException;
	public List<PreSolicitud> getPreSolicitudes(Long archivoId)  throws CustomException;
}
