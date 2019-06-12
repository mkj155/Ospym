package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.ImportForm;
import com.osdepym.form.SolicitudesForm;

public interface SolicitudesService {
	public List<AfiliadoTableDTO> buscar(SolicitudesForm form) throws CustomException;
	public List<AfiliadoDTO> buscarExportar(SolicitudesForm form) throws CustomException;
	public List<ObraSocialDTO> getAllObrasSociales() throws CustomException;
	public List<EstadoDTO> getAllEstados() throws CustomException;
	public List<TipoCargaDTO> getAllTipoCarga() throws CustomException;
	public List<TipoAfiliadoDTO> getAllTipoAfiliado() throws CustomException;
	public List<PautaDTO> getPautasByCuit(String cuit) throws CustomException;
	public Integer obtenerSolicitudMultiple() throws CustomException;
	public String[] confirmarAltaAfiliado(Integer id) throws CustomException;
	public String[] anularAfiliado(AfiliadoTableDTO afiliado) throws CustomException;
	Boolean procesarArchivoXLS(ImportForm form, String fileName) throws CustomException;
}
