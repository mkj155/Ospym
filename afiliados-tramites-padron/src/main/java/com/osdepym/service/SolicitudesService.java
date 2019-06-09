package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.SolicitudesForm;

public interface SolicitudesService {
	public List<AfiliadoTableDTO> buscar(SolicitudesForm form) throws CustomException;
	public List<ObraSocialDTO> getAllObrasSociales() throws CustomException;
	public List<EstadoDTO> getAllEstados() throws CustomException;
}
